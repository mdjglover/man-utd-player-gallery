package glover.mike.cs6314assignment1;

import android.content.Context;
import android.content.res.Resources;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Mike Glover on 10/11/2017.
 */

public class XMLPlayerParser {
    private Player[] data = null;
    private Context context = null;

    public XMLPlayerParser(Context c){

        this.context = c;

        // grab the data from the xml

        // get the doc parser ready for people.xml
        InputStream is = this.context.getResources().openRawResource(R.raw.players);
        DocumentBuilder builder = null;
        Document doc = null;

        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(is);

        } catch(Exception e) {}

        // chop all the nodes

        NodeList nameList = doc.getElementsByTagName("name");
        NodeList positionList = doc.getElementsByTagName("position");
        NodeList squadNumberList = doc.getElementsByTagName("squadNumber");
        NodeList imageList = doc.getElementsByTagName("image");
        NodeList bioList = doc.getElementsByTagName("bio");
        NodeList bioPagesList = doc.getElementsByTagName("bioPages");
        NodeList youtubeIDList = doc.getElementsByTagName("youtube");
        NodeList dobList = doc.getElementsByTagName("dob");
        NodeList joinedList = doc.getElementsByTagName("joined");
        NodeList joinedFromList = doc.getElementsByTagName("joinedFrom");
        NodeList unitedDebutList = doc.getElementsByTagName("unitedDebut");
        NodeList appearancesList = doc.getElementsByTagName("appearances");
        NodeList premAppearancesList = doc.getElementsByTagName("premAppearances");
        NodeList premWinsList = doc.getElementsByTagName("premWins");
        NodeList premLossesList = doc.getElementsByTagName("premLosses");
        NodeList premSignificantStatList = doc.getElementsByTagName("premSignificantStat");


        //traverse NodeLists to make the data array
        data = new Player[nameList.getLength()];

        for (int i = 0; i < data.length; i++){
            String name = nameList.item(i).getFirstChild().getNodeValue();
            String position = positionList.item(i).getFirstChild().getNodeValue();
            String squadNumber = squadNumberList.item(i).getFirstChild().getNodeValue();
            String imageString = imageList.item(i).getFirstChild().getNodeValue();
            int imageId = c.getResources().getIdentifier(imageString, "drawable", c.getPackageName());
            String bio = bioList.item(i).getFirstChild().getNodeValue();
            String bioPagesStr = bioPagesList.item(i).getFirstChild().getNodeValue();
            int bioPages = Integer.parseInt(bioPagesStr);
            String youtubeID = youtubeIDList.item(i).getFirstChild().getNodeValue();
            String dob = dobList.item(i).getFirstChild().getNodeValue();
            String joined = joinedList.item(i).getFirstChild().getNodeValue();
            String joinedFrom = joinedFromList.item(i).getFirstChild().getNodeValue();
            String unitedDebut = unitedDebutList.item(i).getFirstChild().getNodeValue();
            String appearances = appearancesList.item(i).getFirstChild().getNodeValue();
            String premAppearances = premAppearancesList.item(i).getFirstChild().getNodeValue();
            String premWins = premWinsList.item(i).getFirstChild().getNodeValue();
            String premLosses = premLossesList.item(i).getFirstChild().getNodeValue();
            String premSignificantStat = premSignificantStatList.item(i).getFirstChild().getNodeValue();

            data[i] = new Player(name, position, squadNumber, imageId, bio, bioPages, youtubeID, dob, joined,
                    joinedFrom, unitedDebut, appearances, premAppearances, premWins, premLosses, premSignificantStat);
        }

    }

    public Player[] getData(){
        return data;
    }

    public Player getData(int i){
        return data[i];
    }

}
