import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alexanderhughes on 2/10/16.
 */
public class Review {
    public static Scanner scanner = new Scanner(System.in);
    public static Movie movie = new Movie();

    public static void main(String[] args) {
        while (true) {
            try {
                movie = loadMovie();
            }
            catch (FileNotFoundException e) {

                System.out.print("Enter the title of the movie: ");
                movie.title = scanner.nextLine();
                System.out.printf("Enter the director of %s: ", movie.title);
                movie.director = scanner.nextLine();
                System.out.printf("Enter the star of %s: ", movie.title);
                movie.star = scanner.nextLine();
                System.out.printf("Enter the genre of %s: ", movie.title);
                movie.genre = scanner.nextLine();
                System.out.printf("Enter the length in minutes of %s: ", movie.title);
                movie.length = Integer.valueOf(scanner.nextLine());
                //Movie movie = new Movie(title, director, star, genre, length);

                try {
                    saveMovie();
                }
                catch (IOException eIo) {
                    e.printStackTrace();
                }
                System.out.println("Goodbye.");
                System.exit(0);
            }
            System.out.printf("Title: %s\nDirector: %s\nStar: %s\nGenre: %s\nLength: %s " +
                    "minutes\n", movie.title, movie.director, movie.star, movie.genre, movie.length);
            System.out.println("Would you like to update anything? [y/n]");
            String answer = scanner.nextLine();
            switch (answer) {
                case "y":
                    System.out.println("What would you like to update?");
                    String choice = scanner.nextLine().toLowerCase();
                    switch (choice) {
                        case "title":
                            System.out.print("Re-enter title: ");
                            movie.title = scanner.nextLine();
                            break;
                        case "director":
                            System.out.print("Re-enter director: ");
                            movie.director = scanner.nextLine();
                            break;
                        case "star":
                            System.out.print("Re-enter star: ");
                            movie.star = scanner.nextLine();
                            break;
                        case "genre":
                            System.out.print("Re-enter genre: ");
                            movie.genre = scanner.nextLine();
                            break;
                        case "length":
                            System.out.print("Re-enter length: ");
                            movie.length = Integer.valueOf(scanner.nextLine());
                            break;
                        default:
                            System.out.println("Invalid entry!");

                    }
                    try {
                        saveMovie();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                case "n":
                    System.out.println("Have a nice day.");
                    System.exit(0);
                default:
                    System.out.println("Invalid entry!");
            }
            break;
        }
    }

    public static void saveMovie() throws IOException {  //save game code
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(movie);
        File f = new File("movie.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
        System.out.println("Movie Review Saved!!!");
    }
    public static Movie loadMovie() throws FileNotFoundException {
        File f = new File("movie.json");
        Scanner scanner = new Scanner(f);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();

        JsonParser parser = new JsonParser();
        return parser.parse(contents, Movie.class);
    }


}
