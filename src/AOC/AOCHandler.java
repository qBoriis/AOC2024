package AOC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AOCHandler {
    public AOCHandler(String var1) {
        File var2 = new File("C:\\Users\\anger\\IdeaProjects\\AOC2024\\src\\Inputs\\Input" + var1 + ".txt");
        ArrayList var3 = new ArrayList();
        if (!var2.exists()) {
            this.solve(new ArrayList());
        } else {
            BufferedReader var4;
            try {
                var4 = new BufferedReader(new FileReader(var2));
            } catch (FileNotFoundException var6) {
                System.err.println("File not found!!");
                this.solve(new ArrayList());
                return;
            }

            try {
                String var5;
                while((var5 = var4.readLine()) != null) {
                    var3.add(var5);
                }

                var4.close();
            } catch (IOException var7) {
                var7.printStackTrace();
            }

            this.solve(var3);
        }
    }

    abstract void solve(List<String> var1);

    public List<Long> convertToLongs(List<String> var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            String var4 = (String)var3.next();
            var2.add(Long.parseLong(var4));
        }

        return var2;
    }
}
