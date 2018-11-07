import java.util.*;

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
         System.out.println("1. 택배 기사");
         System.out.println("2. 학생");
         System.out.println("3. 저장 상황 확인");
         System.out.println("4. 프로그램 종료");
         System.out.println("========================");
         System.out.print("선택 : ");

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
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
         }
         else System.out.println("입력이 잘못되었습니다. 다시 입력해주세요.");
      }
   }

   public static void deliv_mode()
   {
      System.out.println("학생 이름을 입력하세요.");
      String name = sc.next();

      System.out.println("택배 물품을 입력하세요.");
      String product = sc.next();

      System.out.println("보관 날짜를 입력하세요.");
      String deliv_date = sc.next();

      System.out.println("호실을 입력하세요.");
      String room_num = sc.next();

      System.out.println("보관 구역을 입력하세요.");
      String box_loc = sc.next();

      index.add(new Box(name, product, deliv_date, room_num, box_loc));
   }

   public static void stu_mode()
   {
      System.out.println("이름을 입력하세요: ");
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
               System.out.println("택배를 확인하여 수취합니다.");
               System.out.print("수취한 택배 정보: ");
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
         System.out.print("택배 저장 정보: ");
         System.out.printf("%s, %s, %s, %s, %s\n", tmp.name, tmp.product, tmp.deliv_date, tmp.room_num, tmp.box_loc);
      }
   }
}