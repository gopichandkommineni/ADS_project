import java.io.*;
import java.util.*;
public class risingCity{
    
    private static MinHeap mh = new MinHeap();
    static final RedBlackTree rbt = new RedBlackTree();
    static List<Integer> building_list = new ArrayList<>();
    static ListIterator<Integer> iterator = building_list.listIterator(); 
    static FileWriter fileWriter = null;
        




    public static void main(String args[]) throws Exception {


        int counter = 0;
        int i = 0;
        int init= 0;
        int opday;
        int day_count =0;
        String st;
        Node building = null;


        File file = new File("Sample_input2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        File out_file = new File("Sample_Output.txt");
        FileOutputStream fos = new FileOutputStream(out_file);
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        ArrayList<String[]> li = new ArrayList<String[]>(2000);

        while ((st = br.readLine()) != null) 
        {
            String[] s = st.split(":");
            li.add(s);
        }
        
        try{ while(true){


            opday = Integer.parseInt(li.get(i)[0]);
            //System.out.println(opday);
            if(opday == counter){
                    String S = li.get(i)[1];
                    String res = performOperation(S,opday);
                    if(res!="insert"){
                        bw.write(res);
                        bw.newLine();
                    //System.out.println("opDay "+opday+"  Day"+counter);
                    }
                if(i<li.size()-1)
                    i = i+1;
                
            }


            if(building == null && day_count==0)
                    building = mh.remove();
            
            
            if(building.executed_time==building.total_time){
                int bn = building.bno;
                String res = "("+building.bno+","+counter+")";
                rbt.deleteNode(bn);
                bw.write(res);
                bw.newLine();
                building = mh.remove();
                building_list.remove(new Integer(bn));
                if(building==null && mh.isEmpty()){
                    break;
                }
                
                day_count = 0;
                building.executed_time += 1;
                day_count+=1;
                counter++;
                continue;
            }
            if(day_count == 5){
                mh.add(building);
                day_count =0 ;
                building = mh.remove();
            }
            
            building.executed_time += 1;
            day_count+=1;
            counter++;
        }
    }


        catch(Exception e){
           // continue;
        }
        bw.close();
    }   


        private static String performOperation(String S,int opday)throws Exception{
            
            Node temp;
            String res = "";
            if(S.contains("Insert"))
            {   
                String[] ss = S.substring(S.indexOf('(')+1,S.indexOf(')')).split(",");
                int bn = Integer.parseInt(ss[0]);
                int tt = Integer.parseInt(ss[1]);
                int sd = opday;
                Node n = rbt.insert(bn,tt);
                mh.add(n);
                
                building_list.add(bn);
                Collections.sort(building_list);
                return "insert";
            }
            else if(S.contains("Print")){
                    
                    String[] ss = S.substring(S.indexOf('(')+1,S.indexOf(')')).split(",");
                    
                    if(ss.length==1){
                        temp  = rbt.searchTree(Integer.parseInt(ss[0]));
                        res = "("+temp.bno+","+temp.executed_time+","+temp.total_time+")";
                        //bw.write(res);
                        //System.out.println("\n");
                    }
                    else{
                        int i =0;
                        int bn1 = Integer.parseInt(ss[0]);
                        int bn2 = Integer.parseInt(ss[1]);
                    
                        while(i<building_list.size()-1) { 
                            int bn = building_list.get(i);
                            
                            if(bn>=bn1&&bn<bn2){
                                Node t = rbt.searchTree(bn);
                                res += "("+t.bno+","+t.executed_time+","+t.total_time+") , ";   
                            } 
                        i+=1;
                    } 

                    int bn = building_list.get(i);
                    if(bn>=bn1&&bn<bn2){
                        Node t = rbt.searchTree(bn);
                        res = res + "("+t.bno+","+t.executed_time+","+t.total_time+")"; 
                    }

                }
                
            }
            return res;
        }
    
}