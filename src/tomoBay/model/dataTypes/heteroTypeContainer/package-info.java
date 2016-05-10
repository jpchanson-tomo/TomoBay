/**
This package revolves around the HeteroFieldContainer and its associated classes.

# Introduction {#HETERO_TYPE_CONTAINER_introduction}
This is a typesafe container that can hold heterogenous types as defined by a user defineable schema.
This container is useful when dealing with return values from database queries, as you can use the 
framework surrounding this datatype to define a database schema and access the return values, in their
native form, using a field type rather than an indexed list or Map of homogenous types. 

This type is also more widely applicable but I suggest to use this type when it is the ONLY viable
option within your particular problem domain. It also requires a small ecosystem of classes, so again
this is probably not the right choice as a general purpose datatype.

Its based around a modification of the typesafe hetereogeneous container pattern described in Joshua
Bloch's book 'Effective Java' (second edition, Item 29). For a description of the pattern and an 
example see http://www.codeaffine.com/2015/03/04/map-distinct-value-types-using-java-generics/

# Usage {#HETERO_TYPE_CONTAINER_usage}
In order to use the HeteroTypeContainer, there is a little ecosystem of classes that must be set up 
beforehand so that the heterogenous type container will work properly

## 1.define field types{#HETERO_TYPE_CONTAINER_types}
The first thing that must be done is to define the field types that you are going to wish stored in 
the container. The purpose of this is to define meaningful fields that will ultimately fit together 
in a consistant data schema.

A field is defined by implementing the AbstractField interface. The example below shows an example 
of a 'Name' field which could relate to an address table in a database or student record object:

~~~{.java}
public final class Name implements AbstractField
{
	//this int should define the maximum or nominal size of this field depending on what makes sense given the users data
	private static final int size_M = 50;

 	//default ctor
	public Name()
	{super();}

 	//this method defines the fundemental 'Type' of this field. This, ultimately, must correspond
 	//to the actual type of the data, so as this field represents a name it is textual data and 
 	//will be represented by a String. If this field represented an age then 'TypeDef.BYTE' or
 	//'TypeDef.SHORT' would be more appropriate etc.
	@Override
	public String type()
	{return TypeDef.STRING;}

	//this method defines a size for this field, this is not directly used by the HeteroFieldContainer
	//but can be useful for the user as most data should be of a certain size, using this method the
	//user can retrieve this value for checking purposes.
	@Override
	public int size()
	{return Id.size_M;}
}
~~~

In the `type()` method you will notice the use of the `TypeDef` class, this class should be used when
defining the type of a particular field. `TypeDef` contains a bunch of `public static final String variables`
that contain the canonical name of a specific type, the HeteroFieldContainer uses this during its 
type checking in  order to make sure that the data being added/retrieved is of the same type as the 
field that is supposed to represent it.

This is quite a simple procedure but necessary to the functioning of the HeteroFieldContainer. Once 
you have defined all the fields that make up your data schema you can structure the schema.

## 2.define field schema{#HETERO_TYPE_CONTAINER_schema}
Strictly speaking, this part is optional although thoroughly recommended. It is possible to use the 
HeteroFieldContainer with the raw fields, passing a `new Name()` (in our example), however to save 
creating a great many instances that do not really need creating it is best to define a schema.

Included in this library is an empty interface (AbstractTypeSchema) it is not necessary to use this 
interface specifically but it can help clarify and document your intentions. Below is an example of
a data schema.

~~~{.java}
public final class BuyerTable implements AbstractTypeSchema
{
	//The buyerID column of the buyers table
 	// - VARCHAR(40)
 	// - Primary Key
	public static final BuyerID BUYERID = new BuyerID();
	//The name column of the buyers table
 	// - VARCHAR(45)
	public static final Name NAME = new Name();
 	//The street1 column of the buyers table
 	// - VARCHAR(80)
	public static final Street STREET1 = new Street();
 	//The street2 column of the buyers table
 	// - VARCHAR(80)
	public static final Street STREET2 = new Street();
 	//The city column of the buyers table
 	// - VARCHAR(80)
	public static final City CITY = new City();
	//The county column of the buyers table
 	// - VARCHAR(80)
	public static final County COUNTY = new County();
	//The postcode column of the buyers table
 	// - VARCHAR(15)
	public static final Postcode POSTCODE = new Postcode();
	//The email column of the buyers table
 	// - VARCHAR(100)
	public static final Email EMAIL = new Email();
	//The phoneNo column of the buyers table
 	// - BIGINT(16)
	public static final Phone PHONE = new Phone();
	
 	//private ctor ensures this class is NEVER INSTANTIATED
	private BuyerTable()
	{super();}
}
~~~

The above class represents the buyer table of a database and as such is part of a data schema rather 
than all of it. While not strictly necessary for the use of the container it aids in both efficient 
usage of the container as well as allowing you to formalise and document your data schema within the
program code, making it easier to modify and maintain, as well as making your intentions clear when
using the container.

## 3.use container{#HETERO_TYPE_CONTAINER_use}
The usage of the container itself is relatively straightforward; after creating a new instance of the
container:

~~~{.java}
HeteroFieldContainer containerInstance = new HeteroFieldContainer();
~~~

it can be populated with data:

~~~{.java}
containerInstance.add(BuyerTable.NAME, "Jeff the plumber");
containerInstance.add(BuyerTable.BUYERID, "jeff43");
containerInstance.add(BuyerTable.STREET1, "12 some apartement building");
containerInstance.add(BuyerTable.STREET2, "some street");
containerInstance.add(BuyerTable.COUNTY, "a county");
containerInstance.add(BuyerTable.CITY, "cityville");
containerInstance.add(BuyerTable.POSTCODE, "AB12 9ZX");
containerInstance.add(BuyerTable.EMAIL, "jeff@plumber.co.uk");
containerInstance.add(BuyerTable.PHONE, "441234567890");
~~~

The container does not need to have all the fields in a schema, and they do not have to be in any
particular order, however there is a restriction that the container can only contain one instance of
any particular field.

In order to retrieve data from the container, the following procedure is followed:

~~~{.java}
String name = containerInstance.get(BuyerTable.NAME, ClassRef.STRING);
long phone  = containerInstance.get(BuyerTable.PHONE, ClassRef.INTEGER);
~~~

in the above example the Name field and the Phone field are retrieved from the HeteroFieldContainer.
You will notice the `ClassRef` class being used as a type identifier for the container, this is 
similar to the `TypeDef` class in the sense that it provides a series of `public static final` variables
of type `Class<T>`. The reasoning behind this is that in a container which can contain any number of
arbitrary types in order to aid in safety the container enforces that the user should know the type of
the field that they are asking for.

### Exceptions {#HETERO_TYPE_CONTAINER_exceptions}
There are three situations in which this container should throw an exception:
1. When the user tries to add data to the container but the type of the field is different from the 
type of the data provided.
2. When the user tries to retrieve data but the type of the field is different from the type of the 
data requested.
3. When the user tries to request a field that is not currently stored in the container.

During these scenarios the container will throw an exception:
- in cases (1) and (2), the container will throw a ClassCastException along with a message informing
the user what has gone wrong.
- in case (3) the container will throw a NullPointerException along with a message informaing the 
user what has gone wrong.

# References {#HETERO_TYPE_CONTAINER_references}
- libAPE.dataTypes.heteroTypeContainer.HeteroFieldContainer
- http://www.codeaffine.com/2015/03/04/map-distinct-value-types-using-java-generics/
- Joshua Bloch, Effective Java, second edition, Item 29

 * @author Jan P.C. Hanson
 */
package tomoBay.model.dataTypes.heteroTypeContainer;