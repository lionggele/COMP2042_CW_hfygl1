package com.project_2048;

public class highScore {






}



    /*

    static FileReader readFile;
    static BufferedReader reader;




    public static String getHighScore() {
        int highScore = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("highscore.dat"));
            String line = reader.readLine();
            while (line != null)                 // read the score file line by line
            {
                try {
                    int score = Integer.parseInt(line.trim());   // parse each line as an int
                    if (score > highScore)                       // and keep track of the largest
                    {
                        highScore = score;
                    }
                } catch (NumberFormatException e1) {
                    // ignore invalid scores
                    //System.err.println("ignoring invalid score: " + line);
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException ex) {
            System.err.println("ERROR reading scores from file");
        }

        return String.valueOf(highScore);
    }
}
        /*
        try{
            readFile = new FileReader("highscore.dat");
            reader = new BufferedReader(readFile);
            return reader.readLine();

        }
        catch (Exception e){
            return "0";
        }
        finally{
            try{
                if(!(reader != null)) {
                    reader.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
         */



    //Integer.parseInt(highScore.split (:)[1]))

/*
    public void CheckScore() throws IOException {
        if (score > highScore){

            File scoreFile = new File("highscore.dat");
            if(!scoreFile.exists()){
                scoreFile.createNewFile();
            }
            else{

            }


            
        }
    }

 */


