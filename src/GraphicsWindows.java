import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class GraphicsWindows1 {
    public JFrame windows1 = new JFrame("Acasa Aplicatie");
    public JFrame windows2 = new JFrame("Meniu de aplicatii");
    public JFrame windows3 = new JFrame("Bilete");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GraphicsWindows1 windows = new GraphicsWindows1();
                    windows.windows1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    GraphicsWindows1() {
        initialize();
    }
    void initialize() {
        //fereastra1 de home, configurari generale
        windows1.setBounds(100, 100, 859, 420);
        windows1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows1.setResizable(false);
        windows1.getContentPane().setLayout(null);
        windows1.setBackground(Color.CYAN);

        JLabel firstText = new JLabel("Doriti sa aflati diversitatea de optiuni de relaxare sau sa achizitionati un bilet?");
        firstText.setFont(new Font("Tohoma", Font.PLAIN, 18));
        firstText.setBounds(145, 60, 1000, 50);
        windows1.add(firstText);

        JButton entertainment = new JButton("Divertisment");
        entertainment.setBounds(260, 150, 150, 50);
        windows1.add(entertainment);

        JButton tickets = new JButton("Bilete");
        tickets.setBounds(410, 150, 150, 50);
        windows1.add(tickets);

        //actiunea butonului entertainment
        entertainment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windows1.setVisible(false);

                //configurari generale fereastra2
                windows2.setBounds(100, 100, 859, 420);
                windows2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                windows2.setResizable(false);
                windows2.getContentPane().setLayout(null);

                //instantiere interfetei Entertainment
                AbstractFactory ent = FactoryCreator.getFactory("Entertainment");

                //butonul de back din interiorul ferestrei 2 spre fereastra 1
                JButton comuta_fromEnt_toHome = new JButton("Acasa");
                comuta_fromEnt_toHome.setBounds(690, 340, 140, 30);
                comuta_fromEnt_toHome.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        windows2.setVisible(false);
                        windows1.setVisible(true);
                    }
                });
                windows2.add(comuta_fromEnt_toHome);

                //pagina de filme
                JPanel pageMovie = new JPanel();
                pageMovie.setBackground(Color.CYAN);

                //returneaza clasa Movie prin intermediul metodei getNameEntertainment
                ent.getNameEntertainment("Movie");

                JComboBox c1 = new JComboBox(new String[]{"Horror", "Drama", "Actiune", "Comedie", "Pentru copii"});
                JComboBox c2 = new JComboBox(new String[]{"2000 - 2010", "2010 - 2018", "2018 - 2021"});
                JComboBox c3 = new JComboBox(new String[]{"Intre 0 si 2", "Intre 3 si 5", "Intre 6 si 8", "Intre 8 si 10"});

                JLabel l = new JLabel("Genuri de filme: ");
                JLabel l1 = new JLabel("Categorii dupa anul in care a aparut: ");
                JLabel l3 = new JLabel("Nota: ");

                l.setForeground(Color.black);
                l1.setForeground(Color.blue);
                l3.setForeground(Color.red);

                pageMovie.add(l);
                pageMovie.add(c1);
                pageMovie.add(l1);
                pageMovie.add(c2);
                pageMovie.add(l3);
                pageMovie.add(c3);

                //pagina de jocuri
                JPanel pageGames = new JPanel();
                pageGames.setBackground(Color.CYAN);

                //returneaza clasa Games prin intermediul metodei getNameEntertainment
                ent.getNameEntertainment("Games");

                JComboBox comboG1 = new JComboBox(new String[]{"Actiune", "Adentura", "Puzzle", "Strategie", "Sport", "Lupte", "Supravietuire", "Multiplayer"});
                JComboBox comboG2 = new JComboBox(new String[]{"Grand Theft Auto V", "League of Legends", "World of Warcraft", "PUBG: Battlegrounds", "Minecraft", "Candy Crush Saga", "Fortnite", "Roblox"});
                JComboBox comboG3= new JComboBox(new String[]{"Intre 0 si 2", "Intre 3 si 5", "Intre 6 si 8", "Intre 8 si 10"});

                JLabel labelG1 = new JLabel("Tipuri de jocuri");
                JLabel labelG2 = new JLabel("Cele mai populare:");
                JLabel labelG3 = new JLabel("Categorii dupa nota:");

                labelG1.setForeground(Color.black);
                labelG2.setForeground(Color.blue);
                labelG3.setForeground(Color.red);

                pageGames.add(labelG1);
                pageGames.add(comboG1);
                pageGames.add(labelG2);
                pageGames.add(comboG2);
                pageGames.add(labelG3);
                pageGames.add(comboG3);

                //pagina de sport
                JPanel pageSports = new JPanel();
                pageSports.setBackground(Color.CYAN);

                //returneaza clasa Movie prin intermediul metodei getNameEntertainment
                ent.getNameEntertainment("Sports");

                JComboBox comboS1 = new JComboBox(new String[]{"Alpinism", "Atletism", "Badminton", "Ciclism", "Canoe", "Fotbal", "Ice hockey", "Inot", "Judo", "Volei", "Snowboard", "Tenis", "Taekwondo"});
                JComboBox comboS2 = new JComboBox(new String[]{"Putere", "Mixed", "Rezistenta"});
                JComboBox comboS3= new JComboBox(new String[]{"Intre 0 si 5", "Intre 5 si 12", "Intre 12 si 15", "Intre 15 si 23", "Dupa 23 "});

                JLabel labelS1 = new JLabel("Sporturi in ordinea alfabetica: ");
                JLabel labelS2 = new JLabel("Tipuri de jocuri:");
                JLabel labelS3 = new JLabel("in functie de varsta:");

                labelS1.setForeground(Color.black);
                labelS2.setForeground(Color.blue);
                labelS3.setForeground(Color.red);

                pageSports.add(labelS1);
                pageSports.add(comboS1);
                pageSports.add(labelS2);
                pageSports.add(comboS2);
                pageSports.add(labelS3);
                pageSports.add(comboS3);

                //adauga imaginea in pageMovie prin intermediul unei JLabel
                ImageIcon imageMovie = new ImageIcon(getClass().getResource(".\\image\\rsz_movie.jpg"));
                JLabel labelImageMovie = new JLabel(imageMovie);
                pageMovie.add(labelImageMovie);

                //adauga imaginea in pageGame prin intermediul unei JLabel
                ImageIcon imageGames = new ImageIcon(getClass().getResource(".\\image\\game.jpg"));
                JLabel labelImageGames = new JLabel(imageGames);
                pageGames.add(labelImageGames);

                //adauga imaginea in pageSport prin intermediul unei JLabel
                ImageIcon imageSports = new ImageIcon(getClass().getResource(".\\image\\sport.png"));
                JLabel labelImageSports = new JLabel(imageSports);
                pageSports.add(labelImageSports);

                //adaugare in ferastra2 paginile Sport, jocuri si filme de tip JTabbedPane
                JTabbedPane tp = new JTabbedPane();
                tp.setBounds(0, 0, 859, 400);
                tp.add("Filme", pageMovie);
                tp.add("Jocuri", pageGames);
                tp.add("Sport", pageSports);
                windows2.add(tp);

                windows2.setVisible(true);
            }
        });

        //declaratii continut din fereastra3
        JLabel categorii = new JLabel("Va puteti achizitiona biletele dupa urmatoarele categorii:");

        JComboBox comboB1 = new JComboBox(new String[]{"Luni/Joi: 35 lei", "Vineri/Duminica: 45 lei", "Sarbatori legale: 50 lei"});
        comboB1.setBounds(150, 100, 150, 30);
        JComboBox comboB2 = new JComboBox(new String[]{"Luni/Joi: 40 lei", "Vineri/Duminica: 50 lei ", "Sarbatori legale: 55 lei"});
        comboB2.setBounds(390, 100, 150, 30);
        JComboBox comboB3 = new JComboBox(new String[]{"Luni/Joi: 30 lei", "Vineri/Duminica: 40 lei", "Sarbatori legale: 45 lei"});
        comboB3.setBounds(610, 100, 150, 30);

        //actiunea butonului tickets
        tickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windows1.setVisible(false);

                //configurari generale windows3
                windows3.setBounds(100, 100, 859, 420);
                windows3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                windows3.setResizable(false);
                windows3.getContentPane().setLayout(null);

                //instantiere interfetei tickets, dar si returnarea claselor OldTicket, AdultTickets, ChildrenTickets
                //prin intermediul metodei getTicketType
                AbstractFactory tickets = FactoryCreator.getFactory("Tickets");
                tickets.getTicketType("OldTickets");
                tickets.getTicketType("AdultTickets");
                tickets.getTicketType("ChildrensTickets");

                categorii.setBounds(200, 3, 1000, 50);
                windows3.add(categorii);

                JPanel pageBilete = new JPanel();
                pageBilete.setBounds(10,50,800,80);
                pageBilete.setBackground(Color.CYAN);

                JComboBox comboBM1 = new JComboBox(new String[]{"Luni/Joi: 25 lei", "Vineri/Duminica: 30 lei", "Sarbatori legale: 35 lei"});
                JComboBox comboBM2 = new JComboBox(new String[]{"Luni/Joi: 30 lei", "Vineri/Duminica: 35 lei ", "Sarbatori legale: 40 lei"});
                JComboBox comboBM3 = new JComboBox(new String[]{"Luni/Joi: 20 lei", "Vineri/Duminica: 25 lei", "Sarbatori legale: 30 lei"});

                JLabel labelBM = new JLabel("Filme: ");
                JLabel labelBM1 = new JLabel("Studenti/Batrani: ");
                JLabel labelBM2 = new JLabel("Adulti: ");
                JLabel labelBM3 = new JLabel("Copii: ");

                labelBM1.setForeground(Color.black);
                labelBM2.setForeground(Color.blue);
                labelBM3.setForeground(Color.green);

                pageBilete.add(labelBM);
                pageBilete.add(labelBM1);
                pageBilete.add(comboBM1);
                pageBilete.add(labelBM2);
                pageBilete.add(comboBM2);
                pageBilete.add(labelBM3);
                pageBilete.add(comboBM3);

                JPanel pageBilete1 = new JPanel();
                pageBilete1.setBounds(10,150,800,80);
                pageBilete1.setBackground(Color.PINK);

                JComboBox comboBG1 = new JComboBox(new String[]{"Luni/Joi: 35 lei", "Vineri/Duminica: 40 lei", "Sarbatori legale: 45 lei"});
                JComboBox comboBG2 = new JComboBox(new String[]{"Luni/Joi: 40 lei", "Vineri/Duminica: 45 lei ", "Sarbatori legale: 50 lei"});
                JComboBox comboBG3= new JComboBox(new String[]{"Luni/Joi: 30 lei", "Vineri/Duminica: 35 lei", "Sarbatori legale: 40 lei"});

                JLabel labelBG = new JLabel("Jocuri: ");
                JLabel labelBG1 = new JLabel("Studenti/Batrani: ");
                JLabel labelBG2 = new JLabel("  Adulti: ");
                JLabel labelBG3 = new JLabel("   Copii: ");

                labelBG1.setForeground(Color.black);
                labelBG2.setForeground(Color.blue);
                labelBG3.setForeground(Color.green);

                pageBilete1.add(labelBG);
                pageBilete1.add(labelBG1);
                pageBilete1.add(comboBG1);
                pageBilete1.add(labelBG2);
                pageBilete1.add(comboBG2);
                pageBilete1.add(labelBG3);
                pageBilete1.add(comboBG3);

                JPanel pageBilete2 = new JPanel();
                pageBilete2.setBounds(10,250,800,80);
                pageBilete2.setBackground(Color.GRAY);

                JComboBox comboBS1 = new JComboBox(new String[]{"Luni/Joi: 55 lei", "Vineri/Duminica: 60 lei", "Sarbatori legale: 65 lei"});
                JComboBox comboBS2 = new JComboBox(new String[]{"Luni/Joi: 60 lei", "Vineri/Duminica: 65 lei ", "Sarbatori legale: 70 lei"});
                JComboBox comboBS3= new JComboBox(new String[]{"Luni/Joi: 40 lei", "Vineri/Duminica: 45 lei", "Sarbatori legale: 50 lei"});

                JLabel labelBS = new JLabel("Sporturi: ");
                JLabel labelBS1 = new JLabel("Studenti/Batrani: ");
                JLabel labelBS2 = new JLabel("  Adulti: ");
                JLabel labelBS3 = new JLabel("   Copii: ");

                labelBS1.setForeground(Color.black);
                labelBS2.setForeground(Color.blue);
                labelBS3.setForeground(Color.green);

                pageBilete2.add(labelBS);
                pageBilete2.add(labelBS1);
                pageBilete2.add(comboBS1);
                pageBilete2.add(labelBS2);
                pageBilete2.add(comboBS2);
                pageBilete2.add(labelBS3);
                pageBilete2.add(comboBS3);

                windows3.add(pageBilete);
                windows3.add(pageBilete1);
                windows3.add(pageBilete2);

                //butonul de back din interiorul ferestrei 3 spre fereastra 1
                JButton comuta_fromEnt_toHome = new JButton("Acasa");
                comuta_fromEnt_toHome.setBounds(690, 340, 140, 30);
                comuta_fromEnt_toHome.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        windows3.setVisible(false);
                        windows1.setVisible(true);
                    }
                });
                windows3.add(comuta_fromEnt_toHome);

                windows3.setVisible(true);
            }
        });
        windows1.setVisible(true);
    }
}


//creeam clasa aceasta pt a obtine fabricile de bilete si divertisment
abstract class AbstractFactory extends FactoryCreator {
    abstract Entertainment getNameEntertainment(String entertainment);
    abstract Ticket getTicketType(String typeTicket);
}

class AdultTickets implements Ticket {
    private final String ticketType;
    public AdultTickets() {
        ticketType = null;
    }
    public String getTicketType() {
        return ticketType;
    }
}
class ChildrensTickets implements Ticket {
    private final String ticketType;
    public ChildrensTickets() {
        ticketType = null;
    }
    public String getTicketType() {
        return ticketType;
    }
}
//fabrica 1 (pot folosi atat interface cat si o clasa abstracta)
interface Entertainment {
    String getNameEntertainment();
}
/*
Fabrica de produse de divertismente. (O fabrică este o clasă care returnează produse de un anumit tip)
 */
class EntertainmentFactory extends AbstractFactory {
    public Entertainment getNameEntertainment(String entertainment) {
        if (entertainment == null) {
            return null;
        }
        if (entertainment.equalsIgnoreCase("Games")) {// IgnoreCase pt a putea tasta atat cu litere mici cat si cu litere mari
            System.out.println("ai accesat pagina Games");
            return new Games();
        } else if (entertainment.equalsIgnoreCase("Movie")) {
            System.out.println("ai accesat pagina Movie");
            return new Movie();
        } else if (entertainment.equalsIgnoreCase("Sports")) {
            System.out.println("ai accesat pagina Sports ");
            return new Sports();
        }
        return null;
    }
    public Ticket getTicketType(String typeTicket) {
        return null;
    }
}
// obtine fabricile prin transmiterea unei informatii precum ticketul sau divertismentul
//Am creeat un generator de fabrici pentru a crea fabrici corespunzătoare pe baza diferiților parametri
class FactoryCreator {
    public static AbstractFactory getFactory(String choice) {
        if(choice.equalsIgnoreCase("Entertainment")){
            System.out.println("Ai intrat in meniu Entertainment");
            return new EntertainmentFactory();
        } else if(choice.equalsIgnoreCase("Tickets")){
            System.out.println("Ai intrat in meniu tickets");
            return new TicketsFactory();
        } else {
            System.out.println("Please specify a valid type! ");
            return null;
        }
    }
}
class Games implements Entertainment {
    private final String nameEntertainment;
    public Games() {
        nameEntertainment = null;
    }
    public String getNameEntertainment() {
        return nameEntertainment;
    }
}
class Movie implements Entertainment {
    private final String nameEntertainment;
    public Movie() {
        nameEntertainment = null;
    }
    public String getNameEntertainment() {
        return nameEntertainment;
    }
}
class OldTickets implements Ticket {
    private final String ticketType;//precizez campul de care am nevoie
    public OldTickets() {
        ticketType = null;//initializez campul cu ajutorul unei constructor
    }
    public String getTicketType() {
        return ticketType;
    }
}
class Sports implements Entertainment {
    private final String nameEntertainment;//precizez campul de care am nevoie
    public Sports() {
        nameEntertainment = null;//initializez campul cu ajutorul unui constructor
    }
    public String getNameEntertainment() {
        return nameEntertainment; //fac public campul
    }
}
//fabrica 2
interface Ticket {
    String getTicketType();
}
/*
Fabrica de produse de bilete. (O fabrică este o clasă care returnează produse de un anumit tip)
 */
class TicketsFactory extends AbstractFactory {
    public Entertainment getNameEntertainment(String entertainment) {
        return null;
    }
    public Ticket getTicketType(String typeTicket) {
        if (typeTicket == null) {
            return null;
        }
        if (typeTicket.equalsIgnoreCase("AdultTickets")) {
            System.out.println("adult tickets");
            return new AdultTickets();
        } else if (typeTicket.equalsIgnoreCase("ChildrenTickets")) {
            return new ChildrensTickets();
        } else if (typeTicket.equalsIgnoreCase("OldTickets")) {
            System.out.println("ai intrat in old tickets");
            return new OldTickets();
        }
        return null;
    }
}