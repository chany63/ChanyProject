/*import java.util.*;

class Box
{   
   String name;
   String product;
   String deliv_date;
   String room_num;
   String box_loc;

   public Box(String name, String product, String deliv_date, String room_num, String box_loc)
   {
      this.name = name;
      this.product = product;
      this.deliv_date = deliv_date;
      this.room_num = room_num;
      this.box_loc = box_loc;
   }
}

public class DeliveryPrj
{
   static Scanner sc = new Scanner(System.in);
   static LinkedList<Box> index = new LinkedList<Box>();
   static int box_num;

   public static void main(String[] a)
   {
      box_num = 0;
      while(true)
      {
         System.out.println("========================");
         System.out.println("Select Menu");
         System.out.println("1. �ù� ���");
         System.out.println("2. �л�");
         System.out.println("3. ���� ��Ȳ Ȯ��");
         System.out.println("4. ���α׷� ����");
         System.out.println("========================");
         System.out.print("���� : ");

         int num = sc.nextInt();

         if(num == 1) { 
            deliv_mode();
         }
         else if(num == 2) {
            stu_mode();
         }
         else if(num == 3){
            print_all();
         }
         else if(num == 4) {
            System.out.println("���α׷��� �����մϴ�.");
            System.exit(0);
         }
         else System.out.println("�Է��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
      }
   }

   public static void deliv_mode()
   {
      System.out.println("�л� �̸��� �Է��ϼ���.");
      String name = sc.next();

      System.out.println("�ù� ��ǰ�� �Է��ϼ���.");
      String product = sc.next();

      System.out.println("���� ��¥�� �Է��ϼ���.");
      String deliv_date = sc.next();

      System.out.println("ȣ���� �Է��ϼ���.");
      String room_num = sc.next();

      System.out.println("���� ������ �Է��ϼ���.");
      String box_loc = sc.next();

      index.add(new Box(name, product, deliv_date, room_num, box_loc));
   }

   public static void stu_mode()
   {
      System.out.println("�̸��� �Է��ϼ���: ");
      String name = sc.next();
      
      while(true)
      {
         boolean check = true;
         Iterator<Box> it = index.iterator();
         
         if(it.hasNext() == false) check = false;
         
         while(it.hasNext()) {
            Box tmp = it.next();
            if(tmp.name.equals(name))
            {
               System.out.println("�ù踦 Ȯ���Ͽ� �����մϴ�.");
               System.out.print("������ �ù� ����: ");
               System.out.printf("%s, %s, %s, %s, %s\n", tmp.name, tmp.product, tmp.deliv_date, tmp.room_num, tmp.box_loc);
               
               index.remove(tmp);
               break;   
            }
            check = false;
         }
         
         if(check == false) break;
      }
   }

   public static void print_all()
   {
      Iterator<Box> it = index.iterator();
      while(it.hasNext())
      {
         Box tmp = it.next();
         System.out.print("�ù� ���� ����: ");
         System.out.printf("%s, %s, %s, %s, %s\n", tmp.name, tmp.product, tmp.deliv_date, tmp.room_num, tmp.box_loc);
      }
   }
}*/