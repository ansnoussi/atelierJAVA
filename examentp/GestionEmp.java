import java.util.*;
import java.io.*;
public class GestionEmp implements Serializable {
    ArrayList<Employe> employes = new ArrayList<Employe>();
    static GestionEmp ge = new GestionEmp();
	public static void main(String[] args) {
        //load();
        loadFile();
        System.out.println("choisir le mode:\n1- ajouter\n2- supprimer\n3- afficher");
        Scanner sin = new Scanner(System.in);
        int mode = sin.nextInt();
        if(mode ==3){
            for(Employe e : ge.employes){
                System.out.println(e);
            }
        }
        while(mode == 1){
            //add
            System.out.println("ajout d un employe");
            System.out.print("entrer imm\t");
            int i = sin.nextInt();
            sin.nextLine();
            if(i==0) break;
            System.out.print("entrer nom\t");
            String n = sin.nextLine();
            System.out.print("entrer prenom\t");
            String p = sin.nextLine();
            System.out.print("entrer salaire\t");
            double s = sin.nextDouble();
            add(new Employe(i, n, p, s));
        }
        if(mode==2){
            //remove
            System.out.println("supprimer employe");
            System.out.print("entrer imm\t");
            int i = sin.nextInt();
            remove(new Employe(i, "", "", 0));
        }
        save();
    }
    public static void add(Employe e){
        ge.employes.add(e);
    }
    public static void remove(Employe e){
        ge.employes.remove(e);
    } 
	public static void load() {
        try {
            FileInputStream fichier = new FileInputStream("employe.ser");
            ObjectInputStream ois = new ObjectInputStream(fichier);
            ge = (GestionEmp) ois.readObject();
            if (ge==null) ge = new GestionEmp();
        } catch (java.io.IOException e) {}catch (ClassNotFoundException e){}
    }
	public static void save() {
        try{
            //serializer
            FileOutputStream f = new FileOutputStream("employe.ser");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(ge);
            oos.flush();
            oos.close();
            //file
            System.setOut(new PrintStream("employe.txt"));
            for(Employe e : ge.employes){
                System.out.println(e);
            }
            
        } catch (IOException e) {}
    }
    public static void loadFile(){
        try{
            Scanner sc = new Scanner(new File("employe.txt"));
            String line = sc.nextLine();
            while(!line.equals("")){
                ge.employes.add(new Employe(line));
                line = sc.nextLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


class Employe implements Serializable{
    private int imm;
    private String nom;
    private String prenom;
    private double salaire;

    public Employe(int i,String n,String p,double s){
        imm=i;
        nom=n;
        prenom=p;
        salaire=s;
    }
    public Employe(String s){
        StringTokenizer st = new StringTokenizer(s);
        imm = Integer.parseInt(st.nextToken());
        nom = st.nextToken();
        prenom = st.nextToken();
        salaire = Double.parseDouble(st.nextToken());
    }
    public String toString(){
        return imm+"\t"+nom+"\t"+prenom+"\t"+salaire;
    }
    public boolean equals(Object o){
        return imm == ((Employe)o).imm;
    }
}