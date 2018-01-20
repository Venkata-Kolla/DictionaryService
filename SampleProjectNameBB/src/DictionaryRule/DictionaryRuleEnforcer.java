package DictionaryRule;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DictionaryRuleEnforcer {
	final String endPoint = "https://od-api.oxforddictionaries.com:443/api/v1/inflections/en/";
    final String app_id = "268830c0";
    final String app_key = "bbe1caef917807f6b084bace8f281247";

	public boolean inputTextEntryMethod(String input){
		boolean isValid = false;
	    try {
	    		String urlWithWord = endPoint + input;
	        URL url = new URL(urlWithWord);
	        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
	        urlConnection.setRequestProperty("Accept","application/json");
	        urlConnection.setRequestProperty("app_id",app_id);
	        urlConnection.setRequestProperty("app_key",app_key);
	        
	        if(urlConnection.getResponseCode() != 404) {
	        		isValid = true;
	        }
	        urlConnection.getResponseMessage();
	        return isValid;
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        return isValid;
	    }
	}

}
