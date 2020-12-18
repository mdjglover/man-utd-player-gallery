package glover.mike.cs6314assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebInfoActivity extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;
    Player player;

    String html;

    Button playerInfoButton;
    Button statsButton;
    Button bioButton;
    Button skillsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_info);

        Log.i("bioButton", "WebInfoActivity started");

        Intent intent = getIntent();
        player = intent.getParcelableExtra("player");
        setTitle(player.getName());

        playerInfoButton = findViewById(R.id.playerInfoButton);
        playerInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PlayerInfoActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        statsButton = findViewById(R.id.statsButton);
        statsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MoreInfoActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        bioButton = findViewById(R.id.bioButton);

        skillsButton = findViewById(R.id.skillsButton);
        skillsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });

        webView = (WebView) findViewById(R.id.webView);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        createWebPage(player.getBio(), player.getBioPages());

        //html = createWebPage(player);
        //webView.loadData(html, "text/html", "UTF-8");

        //webView.loadUrl(player.getWiki());

    }


    private void createWebPage(final String url, final int pages){

        new Thread(new Runnable() {

            final StringBuilder builder = new StringBuilder();

            @Override
            public void run() {
                Document doc;
                builder.append("<html> \n");
                builder.append("<body> \n");

                try {
                    for (int i = 1; i <= pages; i++){
                        doc = Jsoup.connect(url + "?pageNo=" + i).get();
                        Elements bodyContent = doc.select(".doublecolcontainer.playerarticletext");
                        builder.append(bodyContent.outerHtml());
                    }

                    builder.append("</body> \n");
                    builder.append("</html>");

                } catch (IOException e){
                    Toast.makeText(WebInfoActivity.this, "Could not load webpage", Toast.LENGTH_SHORT).show();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadData(builder.toString(), "text/html", "UTF-8");
                    }
                });

            }
        }).start();

    }

}
