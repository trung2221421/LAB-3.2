package trung;
import java.util.*;
import java.io.IOException;
import java.security.spec.ECFieldF2m;
class employee{
    protected String name;
    protected String id;
    protected int code;
    employee(){}
    public employee(String name,String id,int code){
        this.code=code;
        this.id=id;
        this.name=name;
    }

    public String Gname(){
        return name;
    }
    public String Gid(){
        return this.id;
    }
    public void In(){
        Scanner S=new Scanner(System.in);
        System.out.print("Nhap Id: ");
        id=S.next();

        System.out.print("Nhap ten: ");
        name=S.next();

        while(true){
            System.out.print("nhap diem code: ");
            code=S.nextInt();
            if(code>3&&code<1){
                System.out.println("sai! nhap lai");
            }else{
                break;
            }
        }
    }
    public void Out(){
        System.out.println("Id: "+id);
        System.out.println("name: "+name);
        System.out.println("code: "+code);
    }
    public double getBasicSal(){
        return 0;
    }
    public double getPayment(){
        return 0;
    }
}
class Soft extends employee{
    private double bonus;

    Soft(){}
    Soft(String name,String id,int code,double bonus){
        super(name,id,code);
        this.bonus=bonus;
    }

    public void In(){
        Scanner S=new Scanner(System.in);
        System.out.println("SoftWare PM ");
        super .In();
        System.out.print("Nhap bonus: :" );
        bonus=S.nextDouble();
        System.out.println();

    }
    public void Out(){
        System.out.println("SoftWare PM");
        super.Out();
        System.out.println("bonus: "+bonus);
        System.out.println();

    }
    public double getBasicSal(){
        switch (code){
            case 1:
                return 30000000;
            case 2:
                return 20000000;
            case 3:
                return 3200000;
            default:
                return 0;
        }
    }
    public double getPayment(){
        return getBasicSal()+bonus;
    }
}
class pro extends employee{
    private double bonus;
    private int OTMoney;

    pro(){}
    pro(String name,String id,int code,double bonus,int OTMoney){
        super(name,id,code);
        this.bonus=bonus;
        this.OTMoney=OTMoney;
    }

    public void In(){
        Scanner S=new Scanner(System.in);
        System.out.println("SoftWare PM ");
        super .In();
        System.out.print("Nhap bonus: :" );
        bonus=S.nextDouble();
        System.out.print("Nhap OTMoney: :" );
        OTMoney=S.nextInt();
        System.out.println();

    }
    public void Out(){
        System.out.println("SoftWare PM");
        super.Out();
        System.out.println("bonus: "+bonus);
        System.out.println("OTMoney: "+OTMoney);
        System.out.println();
    }
    public double getBasicSal(){
        switch (code){
            case 1:
                return 25000000;
            case 2:
                return 13000000;
            case 3:
                return 600000;
            default:
                return 0;
        }
    }
    public double getPayment(){
        return getBasicSal()+bonus+OTMoney+(getBasicSal()/24);
    }
}
class emList{
    List<employee> em=new ArrayList();
    Scanner S=new Scanner(System.in);


    emList(){}
    private void N(){
        System.out.println("\tNhap");
        while (true) {
            System.out.println("1.SoftWare PM");
            System.out.println("2.Programmer");
            System.out.println("3.Thoat");
            System.out.print("Nhap lua chon: ");
            int c=S.nextInt();
            System.out.println("____________________________");

            if(c==1){
                employee s=new Soft();
                s.In();
                em.add(s);
            }else if(c==2){
                employee s=new pro();
                s.In();
                em.add(s);
            }else if(c==3){
                System.out.println("Thoat");
                break;
            }else {
                System.out.println("Sai! nhap lai!!");
            }
        }
        System.out.println("____________________________");
    }
    private void X(){
        System.out.println("\tXuat");

        for(int i=0;i<em.size();i++){
            em.get(i).Out();
        }
        System.out.println("____________________________");

    }
    private void sum(){
        double tong=0;
        for(int i=0;i<em.size();i++){
            tong+= em.get(i).getPayment();
        }  
        System.out.println("Tong: "+tong);
        System.out.println("____________________________");

    }
    private void Sort(){
        for(int i=0;i<em.size();i++){
            for(int j=i+1;j<em.size();j++){
                if(em.get(i).name.compareTo(em.get(j).Gname())>0){
                    employee temp=em.get(i);
                    em.set(i, em.get(j));
                    em.set(j, temp);
                }
            }
        }
        System.out.println("Mang sau khi sap xep: ");
        this.X();
    }
    private void xoa() throws IOException{
        char tiep;
        do {
            boolean test=true;
            System.out.print("nhap id muon xoa: ");
            String vitri=S.nextLine();
            for(int i=0;i<em.size();i++){
                if(vitri.equals(em.get(i).Gid())){
                    
                    em.get(i).Out();
                    System.out.print("Xac nhan (Y/N): ");
                    char xn=(char) System.in.read();
                    System.in.skip(xn);
                    if(xn=='y'||xn=='Y'){
                        em.remove(i);
                        test=false;
                        break;
                    }else if(xn=='n'||xn=='N'){
                        break;
                    }
                }
            }
            if(test==true){
                System.out.println("id nhan vien khong khop! vui long nhap lai: ");
            }
            tiep=(char) System.in.read();
            System.in.skip(tiep);
        }while(tiep=='t'||tiep=='T');
    }
    public void Manager(){
        System.out.println("\tMENU");
        Scanner S=new Scanner(System.in);

        while (true) {
            System.out.println("1.Nhap");
            System.out.println("2.Xuat");
            System.out.println("3.Tong Luong");
            System.out.println("4.Sap Xep");
            System.out.println("5.Dung");
            System.out.print("Nhap lua chon: ");
            int c=S.nextInt();
            System.out.println("____________________________");
            if(c==1){
                this.N();
            }else if(c==2){
                this.X();
            }else if(c==3){
                this.sum();
            }else if(c==4){
                this.Sort();
            }else if(c==5){
                break;
            }else {
                System.out.println("Loi!Nhap lai!!");
            }

        }
    }
}  
public class bai1 {
    public static void main(String[] args) {
        // employee[] em=new employee[5];
        // em[0]=new Soft("vu","200", 2,13000000);
        // em[1]=new pro("Khoi","3000",2,2, 20000000);
        emList E=new emList();
        E.Manager();
    }
}
