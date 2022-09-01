import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        String shakespeare = "To be, or not to be: that is the question:\nWhether 'tis nobler in the mind to suffer\nThe slings and arrows of outrageous fortune,\nOr to take arms against a sea of troubles,\nAnd by opposing end them? To die: to sleep;";
        FileOutputStream fos = new FileOutputStream("shakespeare.txt",false);
        byte[] buffer = shakespeare.getBytes();
        fos.write(buffer);

        String pasternak = "Быть или не быть, вот в чём вопрос. Достойно ль\nСмиряться под ударами судьбы,\nИль надо оказать сопротивленье\nИ в смертной схватке с целым морем бед\nПокончить с ними? Умереть. Забыться.";
        FileOutputStream fos1 = new FileOutputStream("pasternak.txt", true);
        byte[] buffer1 = pasternak.getBytes();
        fos1.write(buffer1);
        fos.close();
        fos1.close();

        try(FileWriter writer = new FileWriter("pasternak.txt")){
            BufferedReader reader = new BufferedReader(new FileReader("shakespeare.txt"));

            String tmp;
            while ((tmp = reader.readLine())!=null){
                writer.write(tmp);
                writer.write(""+tmp.length());
                writer.write("\r\n");
            }
            reader.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}