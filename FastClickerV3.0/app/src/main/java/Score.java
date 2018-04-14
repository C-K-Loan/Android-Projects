/**
 * Created by loan on 07.08.16.
 *
 * this class represents a score in the game
 *
 * a score is generated when the player has lost the game
 *
 * taps is the amount of successfull right correct taps
 *
 * time survived is the time spent in game mode  alive
 *
 * platz is the position
 *
 *
 * platz correct function is called before sending score to score database so position is ight
 */
public class Score
{
    int taps;
    double time_survived;//wielang hat der spieler durchgehalten
    String name;
    int platz;

    public Score ( int taps, String name,int platz, double time_survived ) {
        this.taps=taps;
        this.name=name;
        this.platz=platz;
        this.time_survived=time_survived;
    }

    public Score () {
        this.taps=-16;
        this.name="chris";
        int platz=1;
        this.time_survived = 15.004;
    }

    public int get_Taps(){
        return this.taps;
    }

    public double get_Time_survived(){
        return this.time_survived;
    }

    public String get_Name (){
        return this.name;
    }

    public int get_Platz(){
        return this.platz;
    }

    /*
    berechnet die position in der dieser score in der Tabelle ist
     */
    public int platz_Update (){
        /*
        todo just a stub
         */
        return this.platz;
    }
}
