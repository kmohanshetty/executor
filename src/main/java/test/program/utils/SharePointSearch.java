package test.program.utils;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class SharePointSearch {

    public static void main(String[] args) throws Exception {
        String sharepointUrl = "https://yourcompany.sharepoint.com/sites/YourSite/_api/web/GetFileByServerRelativeUrl('/sites/YourSite/Shared Documents/sample.txt')/$value";
        String token = "YOUR_ACCESS_TOKEN"; // Obtain this from OAuth

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(sharepointUrl);
            request.addHeader("Authorization", "Bearer " + token);
            request.addHeader("Accept", "application/json;odata=verbose");

            try (CloseableHttpResponse response = client.execute(request)) {
                int statusCode = response.getCode();
                if (statusCode == 200) {
                    String content = EntityUtils.toString(response.getEntity());
                    String searchText = "targetText";

                    if (content.contains(searchText)) {
                        System.out.println("Text found!");
                    } else {
                        System.out.println("Text not found.");
                    }
                } else {
                    System.out.println("Failed to fetch file. Status: " + response.getReasonPhrase() + " (" + statusCode + ")");
                }
            }
        }
    }
}
