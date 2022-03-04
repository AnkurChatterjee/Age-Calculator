import java.io.*;
class AgeCalculator
{
    String d1,d2;
    int arr[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public AgeCalculator(String x,String y)
    {
        d1=x;
        d2=y;
    }

    public void calculate()
    {   
        d1=d1.trim();
        int ya,ma,da;
        int i=d1.indexOf('/');
        int j=d1.lastIndexOf('/');
        String dd=d1.substring(0,d1.indexOf('/'));
        String mm=d1.substring(d1.indexOf('/')+1,d1.lastIndexOf('/'));
        String yy=d1.substring(d1.lastIndexOf('/')+1);
        int db=Integer.parseInt(dd);
        int mb=Integer.parseInt(mm);
        int yb=Integer.parseInt(yy);
        if(mb>12 || mb<1)
        {
            System.out.println("Invalid month entry in date of birth. Please retry with a valid input.\n");
            return;
        }
        if(db>arr[mb] || db<1)
        {
            System.out.println("Invalid day entry in date of birth. Please retry with a valid input.\n");
            return;
        }
        d2=d2.trim();
        dd=d2.substring(0,d2.indexOf('/'));
        mm=d2.substring(d2.indexOf('/')+1,d2.lastIndexOf('/'));
        yy=d2.substring(d2.lastIndexOf('/')+1);
        int dc=Integer.parseInt(dd);
        int mc=Integer.parseInt(mm);
        int yc=Integer.parseInt(yy);
        if(mc>12 || mc<1)
        {
            System.out.println("Invalid month entry in current date. Please retry with a valid input.\n");
            return;
        }
        if(dc>arr[mc] || dc<1)
        {
            System.out.println("Invalid day entry in current date. Please retry with a valid input.\n");
            return;
        }
        if(mc>mb)
        {
            ya=yc-yb;
            if(dc>db)
            {
                ma=mc-mb;
                da=dc-db;
            }
            else
            {
                ma=mc-mb-1;
                da=arr[mc-1]-db+dc;
            }
        }
        else if(mc<mb)
        {
            ya=yc-yb-1;
            if(dc>db)
            {
                ma=12-mb+mc;
                da=dc-db;
            }
            else
            {
                ma=12-mb+mc-1;
                da=arr[mc-1]-db+dc;
            }
        }
        else //if mc==mb
        {
            ya=yc-yb;
            if(dc>=db)
            {
                ma=mc-mb;
                da=dc-db;
            }
            else
            {
                ya=ya-1;
                ma=12-mb+mc-1;
                da=arr[mc-1]-db+dc;
            }
        }
        System.out.println("Age is: "+ya+" YEARS "+ma+" MONTHS "+da+" DAYS \n");
    }

    public static void main(String arg[])throws IOException
    {
        int ch;
        String x,y;
        InputStreamReader reader =new InputStreamReader(System.in);
        BufferedReader input=new BufferedReader(reader);
        while(true)
        {
            System.out.println("Enter date in dd/mm/yyyy format.");
            System.out.print("Enter date of birth: ");
            x=input.readLine();
            System.out.print("Enter current date: ");
            y=input.readLine();
            AgeCalculator obj=new AgeCalculator(x,y);
            obj.calculate();
            System.out.print("1. Continue\n2. Exit\nEnter your choice: ");
            ch = Integer.parseInt(input.readLine());
            System.out.println();
            switch(ch)
            {
                case 1: continue;
                case 2: System.exit(0);
                    break;
                default: System.out.println("Invalid Entry. Please enter from the given choices.");
            }
        }
    }
}