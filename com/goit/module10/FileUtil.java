package com.goit.module10;
import com.goit.module9.CaesarCipher;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;


public class FileUtil {

    static final String dataFile = "stored";
    DataInputStream in = null;
    static String readFromFile;
    static int shuffle;
    
    public static StringBuilder fileEncrypt(String entered, int shuffle) throws IOException {
        StringBuilder stringB = new StringBuilder(entered);
        System.out.println("Encrypting data..." + stringB);
        String toConvert = new String(stringB);
        CaesarCipher caesarCipher = new CaesarCipher();
        String string3 = new String(caesarCipher.CaesarCipherEncrypt(toConvert, shuffle));
        writeEncrypted(string3);
        return stringB;
    }
    public static void fileDecrypt(int shuffle) throws IOException {
        System.out.println("Decrypting data...");
        String string2 = readEncrypted();
        CaesarCipher caesarCipher = new CaesarCipher();
        String string3 = new String(caesarCipher.CaesarCipherDecrypt(string2, shuffle));
    }
    public static void writeEncrypted(String string3) throws IOException {

        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

            out.writeUTF(string3);

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Reached end of file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readEncrypted() throws IOException {
        DataInputStream in = null;
         try {

            in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

            while (true) {
                readFromFile = in.readUTF();
                System.out.println("Data read from file: " + readFromFile);
            }
        }
        catch (EOFException e ) {
            System.out.println("Reached end of file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (in != null)
            {
                in.close();
            }
        }

        return readFromFile;
    }
}
