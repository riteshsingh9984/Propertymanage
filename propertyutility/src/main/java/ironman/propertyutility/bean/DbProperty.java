/**
 * 
 */
package ironman.propertyutility.bean;

/**
 * @author bmp
 *
 */
public class DbProperty {

    private String portNo;
    private String ipAddress;
    private String password;
    private String info;
	/**
	 * @return the portNo
	 */
	public String getPortNo() {
		return portNo;
	}
	/**
	 * @param portNo the portNo to set
	 */
	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
     
    
	@Override
    public String toString(){
        return portNo+"|"+ipAddress+"|"+password;
    }
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
    
}

