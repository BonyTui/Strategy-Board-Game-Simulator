import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Army{
  
  //Player and Enemy Army Arrays
  private static Units[] PArmy;
  private static Units[] EArmy;
  
  //Card Deck
  private static Cards[] PlayerCards = new Cards[34];
  private static Cards[] EnemyCards = new Cards[27];
  
  static int rounds = 0;
  
  //Options to enable Special Moves
  boolean canHeal = false;
  boolean canBless = false;
  boolean canHaste = false;
  
  boolean canLightning = false;
  boolean canRecall = false;
  boolean canDagger = false;
  boolean canFireBall = false;
  
  boolean canRapidFire = false;
  boolean canSniper = false;
  boolean canWebArrow = false;
  boolean canVolley = false;
  boolean canJoust = false;
  boolean canTrample = false;
  boolean canDismount = false;
  boolean canLance = false;
  boolean canCirclePlayer = false;

  boolean canParry = false;
  boolean canCounter = false;
  boolean canFullPlate = false;
  boolean canBerserk = false;
  
  boolean canBlock = false;
  boolean canAdd = false;
  boolean canTrampleEnemy = false;
  boolean canCircleEnemy = false;


  
  //Starting Number
  int clericCount = 0;
  int mageCount = 0;
  int archerCount = 0;
  int cavalryCount = 0;
  int swordsmanCount = 0;
  int playerCount = 0;
  
  int skeletonCount = 0;
  int goblinCount = 0;
  int orcCount = 0;
  int trollCount = 0;
  int orgeCount = 0;
  int enemyCount = 0;
  
  //Survivors Number
  int clericSurvivor = 0;
  int mageSurvivor = 0;
  int archerSurvivor = 0;
  int cavalrySurvivor = 0;
  int swordsmanSurvivor = 0;
  int playerSurvivor = 0;
  
  int skeletonSurvivor = 0;
  int goblinSurvivor = 0;
  int orcSurvivor = 0;
  int trollSurvivor = 0;
  int orgeSurvivor = 0;
  int enemySurvivor = 0;
  
  //Kills Count
  int clericKill = 0;
  int mageKill = 0;
  int archerKill = 0;
  int cavalryKill = 0;
  int swordsmanKill = 0;
  int playerKill = 0;
  
  int skeletonKill = 0;
  int goblinKill = 0;
  int orcKill = 0;
  int trollKill = 0;
  int orgeKill = 0;
  int enemyKill = 0;
  
  //Average Survivors Number - for summary output
  double clericSurvivorAverage = 0;
  double mageSurvivorAverage = 0;
  double archerSurvivorAverage = 0;
  double cavalrySurvivorAverage = 0;
  double swordsmanSurvivorAverage = 0;
  double playerSurvivorAverage = 0;
  
  double skeletonSurvivorAverage = 0;
  double goblinSurvivorAverage = 0;
  double orcSurvivorAverage = 0;
  double trollSurvivorAverage = 0;
  double orgeSurvivorAverage = 0;
  double enemySurvivorAverage = 0;
  
  //Average Kills Count - for summary output
  double clericKillAverage = 0;
  double mageKillAverage = 0;
  double archerKillAverage = 0;
  double cavalryKillAverage = 0;
  double swordsmanKillAverage = 0;
  double playerKillAverage = 0;
  
  double skeletonKillAverage = 0;
  double goblinKillAverage = 0;
  double orcKillAverage = 0;
  double trollKillAverage = 0;
  double orgeKillAverage = 0;
  double enemyKillAverage = 0;
  
  
  Scanner in = new Scanner(System.in);
  
  
  public Army(int playerArmyNumber){
    PArmy = new Units[playerArmyNumber];
    //The lines below set up the player army array with a pre-set composition - used for quick testing
    //Units[] PArmy2 = {new Cleric(), new Mage(), new Archer(), new Cavalry(), new Swordsman()};
    //PArmy = PArmy2;
  }
  
  public Army(double enemyArmyNumber){
    EArmy = new Units[(int)enemyArmyNumber];
    //The lines below set up the enemy army array with a pre-set composition - used for quick testing
    //Units[] EArmy2 = {new SkeletonArcher(), new GoblinGrenadier(), new OrcWolfRider(), new TrollBerserker(), new TwoHeadedOrge()};
    //EArmy = EArmy2;
  }
  
  public void printAllUnits(){
    //Player Army
    System.out.println();
    System.out.println("Player Army" + "\n");
    for(int i = 0; i < PArmy.length; i++){
      if(PArmy[i] != null){
        System.out.println(PArmy[i].getUnitStats());
      } 
    }
    
    //Enemy Army
    System.out.println();
    System.out.println("Enemy Army" + "\n");
    for(int i = 0; i < EArmy.length; i++){
      if(EArmy[i] != null){
        System.out.println(EArmy[i].getUnitStats());
      } 
    }
  }
  
  public void printAllCards(){
    //Player Cards
    System.out.println();
    System.out.println("Player Cards" + "\n");
    for(int i = 0; i < PlayerCards.length; i++){
      if(PlayerCards[i] != null){
        System.out.println(PlayerCards[i].getType()+PlayerCards[i].getNumber());
      } 
    }
    
    //Enemy Cards
    System.out.println();
    System.out.println("Enemy Cards" + "\n");
    for(int i = 0; i < EnemyCards.length; i++){
      if(EnemyCards[i] != null){
        System.out.println(EnemyCards[i].getType()+EnemyCards[i].getNumber());
      } 
    }
    
  }
  
  public static void main(String[] args){
     //setting up the army size and composition   
     Scanner in = new Scanner(System.in);
      
     System.out.println();
     System.out.println("Enter number of Units for the Player Army");
     int playerArmyNum = in.nextInt();
     System.out.println();
     Army pa = new Army(playerArmyNum);
     pa.initializePlayerArmy();
     
     System.out.println();
     System.out.println("Enter number of Units for the Enemy Army");
     int enemyArmyNum = in.nextInt();
     System.out.println();
     Army ea = new Army((double)enemyArmyNum);
     ea.initializeEnemyArmy();
      
     //sort fastest to slowest units    
     pa.sortArmy();
    
    //test with pre-typed inputs 
    //Army pa = new Army(5);
    //Army ea = new Army(5.0);
    
    //Initialize Player Deck
    for(int i = 0; i < 7; i++){
      PlayerCards[i] = new RegularCard(i+1);
    }
    
    for(int i = 7; i < 14; i++){
      PlayerCards[i] = new RegularCard(i-6);
    }
    
    for(int i = 14; i < 21; i++){
      PlayerCards[i] = new CriticalCard(i-13);
    }
    
    for(int i = 21; i < 24; i++){
      PlayerCards[i] = new SpecialCard(0);
    }
    
    for(int i = 24; i < 27; i++){
      PlayerCards[i] = new EliteCard(0);
    }
    
    for(int i = 27; i < 34; i++){
      PlayerCards[i] = new RegularCard(i-26);
    }
    
    //Initialize Enemy Deck
    for(int i = 0; i < 7; i++){
      EnemyCards[i] = new RegularCard(i+1);
    }
    
    for(int i = 7; i < 14; i++){
      EnemyCards[i] = new RegularCard(i-6);
    }
    
    for(int i = 14; i < 21; i++){
      EnemyCards[i] = new RegularCard(i-13);
    }
    
    for(int i = 21; i < 24; i++){
      EnemyCards[i] = new SpecialCard(0);
    }
    
    for(int i = 24; i < 27; i++){
      EnemyCards[i] = new EliteCard(0);
    }
    
    
    //pa.printAllCards();
    
    pa.printAllUnits();
    
    //Starting number tracker
    pa.countUnits();
    
    //Upgrades are yet to be added
    //pa.upgrades();
    
    pa.battle();
    
    pa.finalOutput();
    
    
  }
  
  public void upgrades(){
   Scanner in = new Scanner(System.in);
   String prevUnit = "";
   String answer = "";
  
   for(int i = 0; i < PArmy.length; i++){
   //Uprgrade options
      if(!PArmy[i].getUnitType().equals(prevUnit)){
         prevUnit = PArmy[i].getUnitType();
         if(PArmy[i].getUnitType().equalsIgnoreCase("Cleric")){
            System.out.println("Enable Heal for Cleric? (y/n)");
            answer = in.next();
            if(answer == "y"){
               canHeal = true;
            }
             System.out.println("Enable Bless for Cleric? (y/n)");
            answer = in.next();
            if(answer == "y"){
               canBless = true;
            }
             System.out.println("Enable Haste for Cleric? (y/n)");
            answer = in.next();
            if(answer == "y"){
               canHaste = true;
            }
         }
      }
   }
  }
  
  public void countUnits(){
  //Starting Number
    for(int i = 0; i < PArmy.length; i++){
      if(PArmy[i].getUnitType() == "Cleric"){
        clericCount++;
        playerCount++;
      }
      if(PArmy[i].getUnitType() == "Mage"){
        mageCount++;
        playerCount++;
      }
      if(PArmy[i].getUnitType() == "Archer"){
        archerCount++;
        playerCount++;
      }
      if(PArmy[i].getUnitType() == "Cavalry"){
        cavalryCount++;
        playerCount++;
      }
      if(PArmy[i].getUnitType() == "Swordsman"){
        swordsmanCount++;
        playerCount++;
      }
    }
    
    
    for(int j = 0; j < EArmy.length; j++){
      if(EArmy[j].getUnitType() == "SkeletonArcher"){
        skeletonCount++;
        enemyCount++;
      }
      if(EArmy[j].getUnitType() == "GoblinGrenadier"){
        goblinCount++;
        enemyCount++;
      }
      if(EArmy[j].getUnitType() == "OrcWolfRider"){
        orcCount++;
        enemyCount++;
      }
      if(EArmy[j].getUnitType() == "TrollBerserker"){
        trollCount++;
        enemyCount++;
      }
      if(EArmy[j].getUnitType() == "TwoHeadedOrge"){
        orgeCount++;
        enemyCount++;
      }
    }
  }
  
  public void initializePlayerArmy(){    
    for(int i = 0; i < PArmy.length; i++){
      System.out.println("Input the unit type for Player Army slot " + (i+1) + ": Cleric, Mage, Archer, Swordsman, or Cavalry");
      String unitType = in.next();
      System.out.println();
      
      //validation of input
      if(unitType.equalsIgnoreCase("Swordsman")){
        System.out.println(unitType + " added to Player Army slot " + (i+1));
        PArmy[i] = new Swordsman();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("Cleric")){
        System.out.println(unitType + " added to Player Army slot " + (i+1));
        PArmy[i] = new Cleric();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("Mage")){
        System.out.println(unitType + " added to Player Army slot " + (i+1));
        PArmy[i] = new Mage();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("Cavalry")){
        System.out.println(unitType + " added to Player Army slot " + (i+1));
        PArmy[i] = new Cavalry();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("Archer")){
        System.out.println(unitType + " added to Player Army slot " + (i+1));
        PArmy[i] = new Archer();
        System.out.println();
      }else{
        System.out.println("Invalid Unity Type, Try Again");
        System.out.println();
        i -= 1;
        continue;
      }
    }
  }
  
  public void initializeEnemyArmy(){    
    for(int i = 0; i < EArmy.length; i++){
      System.out.println("Input the unit type for Enemy Army slot " + (i+1) + ": SkeletonArcher, GoblinGrenadier, OrcWolfRider, TrollBerserker, or TwoHeadedOrge");
      String unitType = in.next();
      System.out.println();
      
      //validation of input
      if(unitType.equalsIgnoreCase("OrcWolfRider")){
        System.out.println(unitType + " added to Enemy Army slot " + (i+1));
        EArmy[i] = new OrcWolfRider();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("SkeletonArcher")){
        System.out.println(unitType + " added to Enemy Army slot " + (i+1));
        EArmy[i] = new SkeletonArcher();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("GoblinGrenadier")){
        System.out.println(unitType + " added to Enemy Army slot " + (i+1));
        EArmy[i] = new GoblinGrenadier();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("TrollBerserker")){
        System.out.println(unitType + " added to Enemy Army slot " + (i+1));
        EArmy[i] = new TrollBerserker();
        System.out.println();
      }else if(unitType.equalsIgnoreCase("TwoHeadedOrge")){
        System.out.println(unitType + " added to Enemy Army slot " + (i+1));
        EArmy[i] = new TwoHeadedOrge();
        System.out.println();
      }else{
        System.out.println("Invalid Unity Type, Try Again");
        System.out.println();
        i -= 1;
        continue;
      }
    }
  }
  
  public void battle(){
    System.out.println();
    System.out.println("How many battles do you want to simulate?");
    rounds = in.nextInt();
    
    for(int r = 0; r < rounds; r++){
      int playerDeathCount = 0;
      int enemyDeathCount = 0;
      boolean playerDeath = false;
      boolean enemyDeath = false;
      
      
      
      int i = 0;
      int j = 0;
      
      while(playerDeath == false && enemyDeath == false){ //battle
        
        if(i > PArmy.length-1){
          i = 0;
        }
        
        if(j > EArmy.length-1){
          j = 0;
        }
        
        //Reserve turns to alive units
        
        while(PArmy[i].getHealth() <= 0){        
          i+=1;
          if(i > PArmy.length-1){
            i = 0;
          }
        }
        
        while(EArmy[j].getHealth() <= 0){
          j+=1;
          if(j > EArmy.length-1){
            j = 0;
          }
        }
        
        
        
        
        Units playerAttack = PArmy[i];          
        
        Units enemyAttack = EArmy[j];
        
        int randomNumPlayer = 0;
        int randomNumEnemy = 0;
        
        /*for(int p = 0; p < PArmy.length; p++){
          if(PArmy[p].getUnitType() == "Swordsman" && PArmy[p].getHealth() > 0){
               NumPlayer = p;
          }else if(PArmy[p].getUnitType() == "Archer" && PArmy[p].getHealth() > 0){
               NumPlayer = p;
          }else if(PArmy[p].getUnitType() == "Mage" && PArmy[p].getHealth() > 0){
               NumPlayer = p;
          }else if(PArmy[p].getUnitType() == "Cleric" && PArmy[p].getHealth() > 0){
               NumPlayer = p;
          }else if(PArmy[p].getUnitType() == "Cavalry" && PArmy[p].getHealth() > 0){
               NumPlayer = p;
          }
        }
        
        for(int e = 0; e < EArmy.length; e++){
          if(EArmy[e].getUnitType() == "TwoHeadedOrge" && EArmy[e].getHealth() > 0){
               NumEnemy = e;
          }else if(EArmy[e].getUnitType() == "SkeletonArcher" && EArmy[e].getHealth() > 0){
               NumEnemy = e;
          }else if(EArmy[e].getUnitType() == "Mage" && EArmy[e].getHealth() > 0){
               NumEnemy = e;
          }else if(EArmy[e].getUnitType() == "Cleric" && EArmy[e].getHealth() > 0){
               NumEnemy = e;
          }else if(EArmy[e].getUnitType() == "Cavalry" && EArmy[e].getHealth() > 0){
               NumEnemy = e;
          }
        }*/
        
        //If chosen unit is already dead, find another unit to attack
        while(PArmy[randomNumPlayer].getHealth() <= 0){
          randomNumPlayer = (int)(Math.random()*PArmy.length);
        }
        
        while(EArmy[randomNumEnemy].getHealth() <= 0){
          randomNumEnemy = (int)(Math.random()*EArmy.length);
        }
        
        Units playerDefend = PArmy[randomNumPlayer];
        Units enemyDefend = EArmy[randomNumEnemy];
        
        //This player unit attack that enemy unit
        Cards drawnCard;
        
        for(int a = 0; a < playerAttack.getFlips();a++){
          enemyDefend = EArmy[randomNumEnemy];
          drawnCard = PlayerCards[(int)(Math.random()*PlayerCards.length)];
          System.out.println(drawnCard.getType()+drawnCard.getNumber());
          System.out.println();
          if(drawnCard.getType() == "Regular" && drawnCard.getNumber() <= playerAttack.getAttackLevel()){
            playerAttack.dealDamage(playerAttack, enemyDefend);
            System.out.println(playerAttack.getUnitType() + (i+1) + " does " + playerAttack.getDamage() + " damage to " + enemyDefend.getUnitType() + (randomNumEnemy+1));
            enemyDeathCount+=1;
            PArmy[i].setKills(PArmy[i].getKills() + 1);
          }
        }
        
        System.out.println();
        
        //This enemy unit attack that player unit
        for(int b = 0; b < enemyAttack.getFlips();b++){
          playerDefend = PArmy[randomNumPlayer];
          drawnCard = EnemyCards[(int)(Math.random()*EnemyCards.length)];
          System.out.println(drawnCard.getType()+drawnCard.getNumber());
          System.out.println();
          if(drawnCard.getType() == "Regular" && drawnCard.getNumber() <= enemyAttack.getAttackLevel()){
            enemyAttack.dealDamage(enemyAttack, playerDefend);
            System.out.println(enemyAttack.getUnitType() + (j+1) + " does " + enemyAttack.getDamage() + " damage to " + playerDefend.getUnitType() + (randomNumPlayer+1));
            playerDeathCount+=1;
            EArmy[j].setKills(EArmy[j].getKills() + 1);
          }
        }
        
        
        System.out.println();
        
        if(playerDeathCount == PArmy.length){
          playerDeath = true;
          break;
        }
        
        if(enemyDeathCount == EArmy.length){
          enemyDeath = true;
          break;
        } 
        
        //Go to next round
        i+=1;
        j+=1;
      }
      System.out.println("Battle Finished");
      
      
      if(playerDeathCount >= PArmy.length){
        System.out.println("All Player Units died");
      }
      
      if(enemyDeathCount >= EArmy.length){
        System.out.println("All Enemy Units died");
      }
      
      System.out.println();
      
      output();
      
      System.out.println();
      
      restart();
      
    }   
  }
  
  public void sortArmy(){
    Units temp = new Units("Default", 0, 0, 0, 0, 0, 0);
    int n = PArmy.length;  
    
    for(int i = 0; i < n; i++){  
      for(int j = 1; j < (n-i); j++){  
        if(PArmy[j-1].getSpeed() < PArmy[j].getSpeed()){  
          //swap elements  
          temp = PArmy[j-1];  
          PArmy[j-1] = PArmy[j];  
          PArmy[j] = temp;  
        }                     
      } 
    }
    
    Units pemt = new Units("Default", 0, 0, 0, 0, 0, 0);
    int m = EArmy.length;  
    
    for(int a = 0; a < m; a++){  
      for(int b = 1; b < (m-a); b++){  
        if(EArmy[b-1].getSpeed() < EArmy[b].getSpeed()){  
          //swap elements  
          pemt = EArmy[b-1];  
          EArmy[b-1] = EArmy[b];  
          EArmy[b] = pemt;  
        }                     
      }  
    }    
  }
  
  public void restart(){
    for(int i = 0; i < PArmy.length;i++){
      PArmy[i].setHealth(1);
      PArmy[i].setKills(0);
    }
    
    for(int j = 0; j < EArmy.length;j++){
      EArmy[j].setHealth(1);
      EArmy[j].setKills(0);
    }
        
    //Survivors Number
    clericSurvivor = 0;
    mageSurvivor = 0;
    archerSurvivor = 0;
    cavalrySurvivor = 0;
    swordsmanSurvivor = 0;
    playerSurvivor = 0;
    
    skeletonSurvivor = 0;
    goblinSurvivor = 0;
    orcSurvivor = 0;
    trollSurvivor = 0;
    orgeSurvivor = 0;
    enemySurvivor = 0;
    
    //Kills Count
    clericKill = 0;
    mageKill = 0;
    archerKill = 0;
    cavalryKill = 0;
    swordsmanKill = 0;
    playerKill = 0;
    
    skeletonKill = 0;
    goblinKill = 0;
    orcKill = 0;
    trollKill = 0;
    orgeKill = 0;
    enemyKill = 0;
  }
  
  public void Cards(Units attacker, Units defender){
    int flips = (int)(Math.random()*7);
  }
  
  public void output(){
    
    System.out.println("Result");
    //Variables placed outside
    
    
    
    
    //Survivors Number
    for(int i = 0; i < PArmy.length; i++){
      if(PArmy[i].getUnitType() == "Cleric" && PArmy[i].getHealth() > 0){
        clericSurvivor++;
        clericSurvivorAverage++;
        playerSurvivor++;
      }
      if(PArmy[i].getUnitType() == "Mage" && PArmy[i].getHealth() > 0){
        mageSurvivor++;
        mageSurvivorAverage++;
        playerSurvivor++;
      }
      if(PArmy[i].getUnitType() == "Archer" && PArmy[i].getHealth() > 0){
        archerSurvivor++;
        archerSurvivorAverage++;
        playerSurvivor++;
      }
      if(PArmy[i].getUnitType() == "Cavalry" && PArmy[i].getHealth() > 0){
        cavalrySurvivor++;
        cavalrySurvivorAverage++;
        playerSurvivor++;
      }
      if(PArmy[i].getUnitType() == "Swordsman" && PArmy[i].getHealth() > 0){
        swordsmanSurvivor++;
        swordsmanSurvivorAverage++;
        playerSurvivor++;
      }
    }
    
    for(int j = 0; j < EArmy.length; j++){
      if(EArmy[j].getUnitType() == "SkeletonArcher" && EArmy[j].getHealth() > 0){
        skeletonSurvivor++;
        skeletonSurvivorAverage++;
        enemySurvivor++;
      }
      if(EArmy[j].getUnitType() == "GoblinGrenadier" && EArmy[j].getHealth() > 0){
        goblinSurvivor++;
        goblinSurvivorAverage++;
        enemySurvivor++;
      }
      if(EArmy[j].getUnitType() == "OrcWolfRider" && EArmy[j].getHealth() > 0){
        orcSurvivor++;
        orcSurvivorAverage++;
        enemySurvivor++;
      }
      if(EArmy[j].getUnitType() == "TrollBerserker" && EArmy[j].getHealth() > 0){
        trollSurvivor++;
        trollSurvivorAverage++;
        enemySurvivor++;
      }
      if(EArmy[j].getUnitType() == "TwoHeadedOrge" && EArmy[j].getHealth() > 0){
        orgeSurvivor++;
        orgeSurvivorAverage++;
        enemySurvivor++;
      }
    }
    
    
    
    //Kills Count
    for(int i = 0; i < PArmy.length; i++){
      if(PArmy[i].getUnitType() == "Cleric"){
        clericKill += PArmy[i].getKills();
        clericKillAverage += PArmy[i].getKills();
        playerKill += PArmy[i].getKills();
      }
      if(PArmy[i].getUnitType() == "Mage"){
        mageKill += PArmy[i].getKills();
        mageKillAverage += PArmy[i].getKills();        
        playerKill += PArmy[i].getKills();
      }
      if(PArmy[i].getUnitType() == "Archer"){
        archerKill += PArmy[i].getKills();
        archerKillAverage += PArmy[i].getKills();
        playerKill += PArmy[i].getKills();
      }
      if(PArmy[i].getUnitType() == "Cavalry"){
        cavalryKill += PArmy[i].getKills();
        cavalryKillAverage += PArmy[i].getKills();
        playerKill += PArmy[i].getKills();
      }
      if(PArmy[i].getUnitType() == "Swordsman"){
        swordsmanKill += PArmy[i].getKills();
        swordsmanKillAverage += PArmy[i].getKills();
        playerKill += PArmy[i].getKills();
      }
    }
    
    for(int j = 0; j < EArmy.length; j++){
      if(EArmy[j].getUnitType() == "SkeletonArcher"){
        skeletonKill += EArmy[j].getKills();
        skeletonKillAverage += EArmy[j].getKills();
        enemyKill += EArmy[j].getKills();
      }
      if(EArmy[j].getUnitType() == "GoblinGrenadier"){
        goblinKill += EArmy[j].getKills();
        goblinKillAverage += EArmy[j].getKills();
        enemyKill += EArmy[j].getKills();
      }
      if(EArmy[j].getUnitType() == "OrcWolfRider"){
        orcKill += EArmy[j].getKills();
        orcKillAverage += EArmy[j].getKills();
        enemyKill += EArmy[j].getKills();
      }
      if(EArmy[j].getUnitType() == "TrollBerserker"){
        trollKill += EArmy[j].getKills();
        trollKillAverage += EArmy[j].getKills();
        enemyKill += EArmy[j].getKills();
      }
      if(EArmy[j].getUnitType() == "TwoHeadedOrge"){
        orgeKill += EArmy[j].getKills();
        orgeKillAverage += EArmy[j].getKills();
        enemyKill += EArmy[j].getKills();
      }
    }
    
    
    
    
    //Actual Output
    System.out.println("Cleric Starting Number, Survivors, and Kills:           " + clericCount + " " + clericSurvivor + " " + clericKill);
    System.out.println("Mage Starting Number, Survivors, and Kills:             " + mageCount + " " + mageSurvivor + " " + mageKill);
    System.out.println("Archer Starting Number, Survivors, and Kills:           " + archerCount + " " + archerSurvivor + " " + archerKill);
    System.out.println("Calvary Starting Number, Survivors, and Kills:          " + cavalryCount + " " + cavalrySurvivor + " " + cavalryKill);
    System.out.println("Swordsman Starting Number, Survivors, and Kills:        " + swordsmanCount + " " + swordsmanSurvivor + " " + swordsmanKill);
    System.out.println("Total:                                                  " + playerCount + " " + playerSurvivor + " " + playerKill);
    
    System.out.println();
    
    System.out.println("Skeleton Archer Starting Number, Survivors, and Kills:  " + skeletonCount + " " + skeletonSurvivor + " " + skeletonKill);
    System.out.println("Goblin Grenadier Starting Number, Survivors, and Kills: " + goblinCount + " " + goblinSurvivor + " " + goblinKill);
    System.out.println("Orc Wolf Rider Starting Number, Survivors, and Kills:   " + orcCount + " " + orcSurvivor + " " + orcKill);
    System.out.println("Troll Berserke Starting Number, Survivors, and Kills:   " + trollCount + " " + trollSurvivor + " " + trollKill);
    System.out.println("Orge Starting Number, Survivors, and Kills:             " + orgeCount + " " + orgeSurvivor + " " + orgeKill);
    System.out.println("Total:                                                  " + enemyCount + " " + enemySurvivor + " " + enemyKill);
    
    
  }
  
  public void finalOutput(){
    
    playerSurvivorAverage = (clericSurvivorAverage+mageSurvivorAverage+archerSurvivorAverage+cavalrySurvivorAverage+swordsmanSurvivorAverage)/rounds;
    playerKillAverage = (clericKillAverage+mageKillAverage+archerKillAverage+cavalryKillAverage+swordsmanKillAverage)/rounds;
    
    enemySurvivorAverage = (skeletonSurvivorAverage+goblinSurvivorAverage+orcSurvivorAverage+trollSurvivorAverage+orgeSurvivorAverage)/rounds;
    enemyKillAverage = (skeletonKillAverage+goblinKillAverage+orcKillAverage+trollKillAverage+orgeKillAverage)/rounds;

      
    System.out.println();
    System.out.println("Final Output");
    
    System.out.println("Cleric Starting Number, Average Survivors, and Average Kills:           " + clericCount+ "  " + String.format("%.2f",(clericSurvivorAverage/rounds)) + "  " + String.format("%.2f",(clericKillAverage/rounds)));
    System.out.println("Mage Starting Number, Average Survivors, and Average Kills:             " + mageCount + "  " + String.format("%.2f",(mageSurvivorAverage/rounds)) + "  " + String.format("%.2f",(mageKillAverage/rounds)));
    System.out.println("Archer Starting Number, Average Survivors, and Average Kills:           " + archerCount + "  " + String.format("%.2f",(archerSurvivorAverage/rounds)) + "  " + String.format("%.2f",(archerKillAverage/rounds)));
    System.out.println("Calvary Starting Number, Average Survivors, and Average Kills:          " + cavalryCount + "  " + String.format("%.2f",(cavalrySurvivorAverage/rounds)) + "  " + String.format("%.2f",(cavalryKillAverage/rounds)));
    System.out.println("Swordsman Starting Number, Average Survivors, and Average Kills:        " + swordsmanCount + "  " + String.format("%.2f",(swordsmanSurvivorAverage/rounds)) + "  " + String.format("%.2f",(swordsmanKillAverage/rounds)));
    System.out.println("Total:                                                                  " + playerCount + "  " + String.format("%.2f",(playerSurvivorAverage)) + "  " + String.format("%.2f",(playerKillAverage)));
    
    System.out.println();
    
    System.out.println("Skeleton Archer Starting Number, Average Survivors, and  Average Kills: " + skeletonCount + "  " + String.format("%.2f",(skeletonSurvivorAverage/rounds)) + "  " + String.format("%.2f",(skeletonKillAverage/rounds)));
    System.out.println("Goblin Grenadier Starting Number, Average Survivors, and Average Kills: " + goblinCount + "  " + String.format("%.2f",(goblinSurvivorAverage/rounds)) + "  " + String.format("%.2f",(goblinKillAverage/rounds)));
    System.out.println("Orc Wolf Rider Starting Number, Average Survivors, and Average Kills:   " + orcCount + "  " + String.format("%.2f",(orcSurvivorAverage/rounds)) + "  " + String.format("%.2f",(orcKillAverage/rounds)));
    System.out.println("Troll Berserke Starting Number, Average Survivors, and Average Kills:   " + trollCount + "  " + String.format("%.2f",(trollSurvivorAverage/rounds)) + "  " + String.format("%.2f",(trollKillAverage/rounds)));
    System.out.println("Orge Starting Number, Average Survivors, and Average Kills:             " + orgeCount + "  " + String.format("%.2f",(orgeSurvivorAverage/rounds)) + "  " + String.format("%.2f",(orgeKillAverage/rounds)));
    System.out.println("Total:                                                                  " + enemyCount + "  " + String.format("%.2f",(enemySurvivorAverage)) + "  " + String.format("%.2f",(enemyKillAverage)));
  }
  
}

//developed by Tony Bui