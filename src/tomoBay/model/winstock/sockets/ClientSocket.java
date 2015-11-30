package tomoBay.model.winstock.sockets;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * This class is responsible for creating a client socket connection to a particular machine at a
 * specified port. It also provides a method of passing information to and receiving information
 * from this socket.
 * @author Jan P.C. Hanson
 *
 */
public class ClientSocket
{
	/**the socket**/
	private Socket winstock_M;
	/**data going to the socket**/
	private DataOutputStream dataIn_M;
	/**data coming from the socket**/
	private DataInputStream dataOut_M;
	
	/**
	 * creates a general socket connection to the specified machine name and port.
	 * @param machineName the ip address or domain name of the machine you wish to connect to.
	 * @param port the port number you wish to communicate with
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public ClientSocket(String machineName, int port) 
			throws UnknownHostException, IOException
	{
		super();
		this.winstock_M = new Socket(machineName, port);
		this.dataIn_M = new DataOutputStream(this.winstock_M.getOutputStream());
		this.dataOut_M = new DataInputStream(this.winstock_M.getInputStream());
	}
	
	/**
	 * get the DataOutputStream associated with this socket connection, allowing the user to 
	 * write to this socket connection.
	 * @return DataOutputStream
	 */
	public DataOutputStream getOutputStream()
	{return this.dataIn_M;}
	
	/**
	 * get the response from the server as a byte array. The length of the byte array returned 
	 * by this method is set to the estimated number of bytes returned by the server and as such
	 * guarantees that it will not be longer, but it may truncate some of the end of the message.
	 * @return byte[] containing the server response.
	 * @throws IOException
	 */
	public byte[] getResponse() throws IOException
	{
		byte[] response = new byte[this.dataOut_M.available()];
		
		this.dataOut_M.readFully(response);
		
		return response;
	}
	
	/**
	 * releases all resources opened by this object or throws an IOException
	 * @return String indicating that the resources are closed.
	 * @throws IOException 
	 */
	public boolean close() throws IOException
	{
		this.dataIn_M.close();
		this.dataOut_M.close();
		this.winstock_M.close();
		
		if(this.dataIn_M ==null  && this.dataOut_M ==null && this.winstock_M == null)
		{return true;}
		else
		{throw new IOException("could not close resources");}
	}
}
