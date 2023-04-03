package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.Domain.Let;
import ba.unsa.etf.rpr.Domain.Putnik;
import ba.unsa.etf.rpr.Exception.KartaException;
import ba.unsa.etf.rpr.business.KartaManager;
import ba.unsa.etf.rpr.business.LetManager;
import ba.unsa.etf.rpr.business.PutnikManager;
import org.apache.commons.cli.*;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;

public class App {
    private static final Option addLet = new Option("l", "add-let", false, "Adding a new flight to database (start-point, destination, date-of-departure, time-of-departure, gate)");
    private static final Option addPutnik = new Option("p", "add-putnik", false, "Adding a new passenger to database (name, surname, mail, username, password)");
    private static final Option deleteLet = new Option("delL", "delete-let", false, "Deleting a flight from database (id)");
    private static final Option getLet = new Option("getL", "get-letovi", false, "Printing all flights from database");
    private static final Option getPutnik = new Option("getP", "get-putnici", false, "Printing all passengers from database");
    private static final Option deletePutnik = new Option("delP", "delete-putnik", false, "Deleting a passenger from database (user-id)");
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar projekat-cli-jar-with-dependencies.jar [option] (parameters)");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addLet);
        options.addOption(deleteLet);
        options.addOption(getLet);
        options.addOption(getPutnik);
        options.addOption(deletePutnik);
        options.addOption(addPutnik);
        return options;
    }

    private static boolean isDigit(String s) {
        try {
            int intValue = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws ParseException, KartaException {
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);
        LetManager letManager = new LetManager();
        PutnikManager putnikManager = new PutnikManager();
        KartaManager kartaManager = new KartaManager();
        if (cl.hasOption(addLet.getOpt()) || cl.hasOption(addLet.getLongOpt())) {
            try {
                Let let = new Let();
                let.setPocetnaDestinacija(cl.getArgList().get(0));
                let.setKrajnjaDestinacija(cl.getArgList().get(1));
                let.setDatum(Date.valueOf(cl.getArgList().get(2)));
                let.setVrijemePolaska(Time.valueOf(cl.getArgList().get(3)));
                let.setTerminal(cl.getArgList().get(4));
                letManager.add(let);
                System.out.println("Flight successfully added to database!");
            } catch (Exception e) {
                System.out.println("Error. Invalid parameters.");
                printFormattedOptions(options);
                System.exit(-1);
            }
        } else if (cl.hasOption(deleteLet.getOpt()) || cl.hasOption(deleteLet.getLongOpt())) {
            Let let = new Let();
            try {
                let = letManager.getByKrajnjaDestinacija(cl.getArgList().get(1));
                letManager.delete(let.getId());
                System.out.println("flight successfuly deleted from database!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("flight with that destination does not exist.");
            } catch (KartaException e) {
                System.out.println("Flight cannot be deleted.");
            }
        } else if (cl.hasOption(getLet.getOpt()) || cl.hasOption(getLet.getLongOpt())) {
            letManager.getAll().forEach(l -> System.out.println(l.getPocetnaDestinacija()+ "-" + l.getKrajnjaDestinacija()));
        } else if (cl.hasOption(getPutnik.getOpt()) || cl.hasOption(getPutnik.getLongOpt())) {
            putnikManager.getAll().forEach(p -> System.out.println(p.getIme() + " " + p.getPrezime() ));
        } else if (cl.hasOption(deletePutnik.getOpt()) || cl.hasOption(deletePutnik.getLongOpt())) {
            try {
                if (!isDigit(cl.getArgList().get(0))) {
                    System.out.println("You must enter a valid passenger id!");
                    return;
                }
                try {
                    putnikManager.delete(Integer.parseInt(cl.getArgList().get(0)));
                    System.out.println("passenger deleted successfully!");
                } catch (KartaException f) {
                    System.out.println("User does not exist!");
                }
            } catch (Exception e) {
                System.out.println("Error. Invalid parameters.");
                printFormattedOptions(options);
                System.exit(-1);
            }
        } else if (cl.hasOption(addPutnik.getOpt()) || cl.hasOption(addPutnik.getLongOpt())) {
            try {
                Putnik putnik = new Putnik();
                putnik.setIme(cl.getArgList().get(0));
                putnik.setPrezime(cl.getArgList().get(1));
                putnik.setMail(cl.getArgList().get(2));
                putnik.setUsername(cl.getArgList().get(3));
                putnik.setPassword(cl.getArgList().get(4));
                putnikManager.add(putnik);
                System.out.println("Passenger successfully added!");
            } catch (Exception e) {
                System.out.println("Error. Invalid parameters.");
                printFormattedOptions(options);
                System.exit(-1);
            }
        } else {
            printFormattedOptions(options);
            System.exit(-1);
        }
    }
}
