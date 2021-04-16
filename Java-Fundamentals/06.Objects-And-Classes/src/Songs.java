import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    private static class Song {
        String typeList;
        String nameSong;
        String durationSong;

        public String getTypeList(){
            return typeList;
        }
        public String getNameSong(){
            return nameSong;
        }
        public  String getDurationSong(){
            return durationSong;
        }
        public void setTypeList (String typeList){
            this.typeList = typeList;
        }
        public  void setNameSong(String nameSong){
            this.nameSong = nameSong;
        }
        public void setDurationSong(String durationSong){
            this.durationSong = durationSong;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = scanner.nextLine().split("_");

            String typeList = input[0];
            String nameSong = input[1];
            String durationSong = input[2];

            Song song = new Song();

            song.setTypeList(typeList);
            song.setNameSong(nameSong);
            song.setDurationSong(durationSong);

            songs.add(song);
        }
        String lastLine = scanner.nextLine();
        if (lastLine.equals("all")){
            for (Song eachSong: songs) {
                System.out.println(eachSong.getNameSong());
            }
        }else {
            for (Song song: songs) {
                if (song.getTypeList().equals(lastLine)){
                    System.out.println(song.getNameSong());
                }
            }
        }

    }
}
