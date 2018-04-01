
public class Mängulaud {
	
	/* mängulaud, kus on laua piirded, koordinaadid mängunuppudel ja nende piirangud, ... */
	/* tiimi nupu tähised näiteks, võib küsida mängu alguses ka kasutajalt: valge-"◆", kes alustab vasakult, ja must-"◇", kes alustab paremalt  */
	/* laud:   
▐✩│✦│✩▌
▐✦│✦│✦▌
▐✦│✦│✦▌
▐✦│✩│✦▌
|◁│✦│▷|
|◁│✦│▷| 
▐✩│✦│✩▌
▐✦│✦│✦▌
	 */
	/* laud on programmis koordinaatides x = [0-7]; y = [0-2] ja ! = ei ole kasutatav ehk
(x, y)
(0, [0,1,2])
(1, [0,1,2])
(2, [0,1,2])
(3, [0,1,2])
(4, [!,1,!])
(5, [!,1,!])
(6, [0,1,2])
(7, [0,1,2])
	 * ehk kui valge täringuvise on 2 siis Nupp nupp = (valge, 2, 0).
	 * on meetod käik, mis prindib välja mänguvälja, asetades õigesse kohta õige sümboli:
System.out.println("▐" + laudJoonista(0,0) + "│" + laudJoonista(0,1) + "│" + laudJoonista(0,2) + " ▌");
System.out.println("▐" + laudJoonista(1,0) + "│" + laudJoonista(1,1) + "│" + laudJoonista(1,2) + " ▌");
System.out.println("▐" + laudJoonista(2,0) + "│" + laudJoonista(2,1) + "│" + laudJoonista(2,2) + " ▌");
jne...
	 */
	
	
}