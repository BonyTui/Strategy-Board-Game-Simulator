import java.util.Arrays;

public class Units{
  private String unitType;
  
  private int flips;
  private int attackLevel;
  private int speed;
  private int size;
  private int health;
  private int damage;
  
  private int kills;
  
  public Units(String type, int f, int a, int sped, int sz, int h, int dmg){
    unitType = type;
    
    flips = f;
    attackLevel = a;
    speed = sped;
    size = sz;
    health = h;
    damage = dmg;
    
    kills = 0;
    
    }  
  
  public String getUnitStats(){
    return "Type: " + unitType + "\n" + 
            "Flips: " + flips + "\n" +
            "Attack Level: " + attackLevel + "\n"+
            "Speed: " + speed + "\n" +
            "Size: " + size + "\n" +
            "Health: " + health + "\n" +
            "Damage: " + damage + "\n";  
  }
  
  public String getUnitType(){
    return unitType;
  }
  
  public int getFlips(){
    return flips;
  }
  
  public int getAttackLevel(){
    return attackLevel;
  }
  
  public void setAttackLevel(int a){
   attackLevel = a;
  }
  
  public int getSpeed(){
    return speed;
  }
  
  public void setSpeed(int s){
    speed = s;
  }
  
  
  public int getSize(){
    return size;
  }
  
  
  public int getHealth(){
    return health;
  }
  
  public void setHealth(int h){
   health = h;
  }
  
  public int getDamage(){
    return damage;
  }
  
  public int getKills(){
    return kills;
  }
  
  public void setKills(int k){
    kills = k;
  }
  
  public static void dealDamage(Units attacker, Units defender){
   defender.setHealth(defender.getHealth() - attacker.getDamage());
  }
  
  //Special Moves
  public void setFlips(int n){
   flips = n;
  }
  
  public void setAttack(int n){
   attackLevel = n;
  }
  
  public void block(){
   health += 1;
  }
  
  public void trample(Units a, Units b, Units c, Units d){
   a.setHealth(a.getHealth() - 1);
   b.setHealth(b.getHealth() - 1);
   c.setHealth(c.getHealth() - 1);
   d.setHealth(d.getHealth() - 1);
  }
  
  public void chainLighting(Units a, Units b){
   dealDamage(a,b);
   //get another flip
  }
  
  public void webArrow(Units a){
   a.setSpeed(1);
  }
  
  public void fullPlate(){
   setHealth(3);
  }
  
  public void berserk(){
   setFlips(2);
   setAttackLevel(3);
  }
}
