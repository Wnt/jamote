
package org.vaadin.jonni.jamote.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "response_code",
    "network_name",
    "connection",
    "dhcp",
    "ip_address",
    "subnet_mask",
    "default_gateway",
    "dns_server_1",
    "dns_server_2",
    "wireless_lan",
    "wireless_direct",
    "musiccast_network",
    "mac_address",
    "airplay_pin"
})
public class NetworkStatus {

    @JsonProperty("response_code")
    private Integer responseCode;
    @JsonProperty("network_name")
    private String networkName;
    @JsonProperty("connection")
    private String connection;
    @JsonProperty("dhcp")
    private Boolean dhcp;
    @JsonProperty("ip_address")
    private String ipAddress;
    @JsonProperty("subnet_mask")
    private String subnetMask;
    @JsonProperty("default_gateway")
    private String defaultGateway;
    @JsonProperty("dns_server_1")
    private String dnsServer1;
    @JsonProperty("dns_server_2")
    private String dnsServer2;
    @JsonProperty("wireless_lan")
    private WirelessLan wirelessLan;
    @JsonProperty("wireless_direct")
    private WirelessDirect wirelessDirect;
    @JsonProperty("musiccast_network")
    private MusiccastNetwork musiccastNetwork;
    @JsonProperty("mac_address")
    private MacAddress macAddress;
    @JsonProperty("airplay_pin")
    private String airplayPin;

    @JsonProperty("response_code")
    public Integer getResponseCode() {
        return responseCode;
    }

    @JsonProperty("response_code")
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    @JsonProperty("network_name")
    public String getNetworkName() {
        return networkName;
    }

    @JsonProperty("network_name")
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    @JsonProperty("connection")
    public String getConnection() {
        return connection;
    }

    @JsonProperty("connection")
    public void setConnection(String connection) {
        this.connection = connection;
    }

    @JsonProperty("dhcp")
    public Boolean getDhcp() {
        return dhcp;
    }

    @JsonProperty("dhcp")
    public void setDhcp(Boolean dhcp) {
        this.dhcp = dhcp;
    }

    @JsonProperty("ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    @JsonProperty("ip_address")
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @JsonProperty("subnet_mask")
    public String getSubnetMask() {
        return subnetMask;
    }

    @JsonProperty("subnet_mask")
    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    @JsonProperty("default_gateway")
    public String getDefaultGateway() {
        return defaultGateway;
    }

    @JsonProperty("default_gateway")
    public void setDefaultGateway(String defaultGateway) {
        this.defaultGateway = defaultGateway;
    }

    @JsonProperty("dns_server_1")
    public String getDnsServer1() {
        return dnsServer1;
    }

    @JsonProperty("dns_server_1")
    public void setDnsServer1(String dnsServer1) {
        this.dnsServer1 = dnsServer1;
    }

    @JsonProperty("dns_server_2")
    public String getDnsServer2() {
        return dnsServer2;
    }

    @JsonProperty("dns_server_2")
    public void setDnsServer2(String dnsServer2) {
        this.dnsServer2 = dnsServer2;
    }

    @JsonProperty("wireless_lan")
    public WirelessLan getWirelessLan() {
        return wirelessLan;
    }

    @JsonProperty("wireless_lan")
    public void setWirelessLan(WirelessLan wirelessLan) {
        this.wirelessLan = wirelessLan;
    }

    @JsonProperty("wireless_direct")
    public WirelessDirect getWirelessDirect() {
        return wirelessDirect;
    }

    @JsonProperty("wireless_direct")
    public void setWirelessDirect(WirelessDirect wirelessDirect) {
        this.wirelessDirect = wirelessDirect;
    }

    @JsonProperty("musiccast_network")
    public MusiccastNetwork getMusiccastNetwork() {
        return musiccastNetwork;
    }

    @JsonProperty("musiccast_network")
    public void setMusiccastNetwork(MusiccastNetwork musiccastNetwork) {
        this.musiccastNetwork = musiccastNetwork;
    }

    @JsonProperty("mac_address")
    public MacAddress getMacAddress() {
        return macAddress;
    }

    @JsonProperty("mac_address")
    public void setMacAddress(MacAddress macAddress) {
        this.macAddress = macAddress;
    }

    @JsonProperty("airplay_pin")
    public String getAirplayPin() {
        return airplayPin;
    }

    @JsonProperty("airplay_pin")
    public void setAirplayPin(String airplayPin) {
        this.airplayPin = airplayPin;
    }

}
