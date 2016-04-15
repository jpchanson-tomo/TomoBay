package tomoBay.model.net;
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
	private Socket socket_M;
	/**data going to the socket**/
	private DataOutputStream dataOut_M;
	/**data coming from the socket**/
	private DataInputStream dataIn_M;
	
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
		this.socket_M = new Socket(machineName, port);
		this.dataOut_M = new DataOutputStream(this.socket_M.getOutputStream());
		this.dataIn_M = new DataInputStream(this.socket_M.getInputStream());
	}
	
	/**
	 * sends the byte array to the socket
	 * @param payload byte[] containing the information to send to the socket
	 * @param responseSize integer representing the number of bytes in the response.
	 * @throws IOException
	 */
	public byte[] send(byte[] payload, int responseSize) throws IOException
	{
		this.dataOut_M.write(payload);
		
		byte[] response = new byte[responseSize];
		
		this.dataIn_M.readFully(response);
		
		return response;
	}

	
	/**
	 * releases all resources opened by this object or throws an IOException
	 * @return String indicating that the resources are closed.
	 * @throws IOException 
	 */
	public boolean close() throws IOException
	{
		this.dataOut_M.close();			this.dataOut_M = null;
		this.dataIn_M.close();			this.dataIn_M = null;
		this.socket_M.close();			this.socket_M = null;
		
		if(this.dataOut_M ==null  && this.dataIn_M ==null && this.socket_M == null)
		{return true;}
		else
		{throw new IOException("could not close resources");}
	}
}
