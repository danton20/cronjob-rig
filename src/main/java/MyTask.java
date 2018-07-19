import java.net.URL;
import java.util.TimerTask;

import org.apache.commons.io.IOUtils;

public class MyTask extends TimerTask {
  String urlApi = "https://iftmnews.000webhostapp.com/rig-profit/update.php?";
  String walletEth = "wallet=0x8dada2f89f5914d001c85054e5270786e83771b9";
  String walletLuxDanton = "wallet=LQXWEWTez9JLUj6e9NoMBAfUXL2Ht9QF7K";
  String coin = "&coin=";
  
  public void run() {
    System.out.println("Atualizando banco de dados");
    System.out.println(getResponseFromUrl(urlApi + walletEth + coin + "ETH"));
    System.out.println(getResponseFromUrl(urlApi + walletLuxDanton + coin + "LUX"));
  }
  
  public String getResponseFromUrl(String url) {
    try {
      return IOUtils.toString(new URL(url));
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
