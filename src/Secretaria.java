import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Secretaria {

    HashMap<String, String> mapa ;

    public Secretaria()
    {
        mapa = new HashMap<>();
    }

    public void load()
    {
        try {
            mapa.clear();
            FileDialog dialog = new FileDialog((Frame)null, "Select file...");
            dialog.setVisible(true);
            String file = dialog.getDirectory()+dialog.getFile();
            System.out.println(file);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;

            while((line =br.readLine()) != null){
                String str[] = line.split(",");
                mapa.put(str[0], str[1]);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void save()
    {
        try (PrintWriter writer = new PrintWriter(new File("secretarias.csv"))){
            StringBuilder sb = new StringBuilder();
            int flag = 0;
            for (Map.Entry<String, String> entry:
                    mapa.entrySet()) {
                if (flag == 0)
                    sb.append(entry.getKey()+","+entry.getValue());
                else
                    sb.append("\n"+entry.getKey()+","+entry.getValue());

                flag++;
            }

            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void list()
    {
        System.out.println("Secretarias:");
        for (Map.Entry<String, String> entry:
                mapa.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public void create(String secreID, String nomsec, String secrepass)
    {
        mapa.put(secreID, nomsec, secrepass)
    }
    public void delete(String nomsec)
    {
        mapa.remove(nomsec);
    }
}