package net.azib.java.students.t980814.lec3;

import java.util.Map;
import java.util.TreeMap;

/**
 * Master
 *
 * @author allan
 */
public class Master {

	public static void main(String[] args) {
/*		String jura = new String("Eesti Kergejõustikuliit (EKJL) läheb olümpiahooajale " +
							     "vastu rekordilise 32,8 miljoni krooni suuruse eelarvega. " +
							     "Samas kinnitas EKJL-i juhatus Valenciasse sise MM-ile sõitvad " +
							     "sportlased, kelleks on kolmikhüppaja Kaire Leibak ja tõkkejooksja " +
							     "Rene Oruman. Eesti Kergejõustikuliidu peasekretäri Urmo Raiendi " +
							     "sõnul on tänavuses eelarveprojektis alaliidu tuludeks kavandatud " +
							     "32,8 miljonit krooni ning kuludeks 32,4 miljonit krooni. " +
							     "Suurem osa kergejõustikuliidu eelarvest tuleb avalikust sektorist, " +
							     "mille toetus ulatub 19,3 mln kroonini. Erafirmadest suursponsorid " +
							     "toetavad meid kokku 9,8 mln krooniga, ülejäänud tulu moodustub " +
							     "rahvusvaheliste kergejõustiku katusorganisatsioonide ja alaliidu " +
							     "omavahenditest, kommenteeris Raiend. " +
							     "Urmo Raiendi sõnul on olümpiahooajal põhirõhk rahvuskoondisega " +
							     "seotud kuludel. Rahvuskoondise ettevalmistust finantseerime 10,6 " +
							     "miljoni krooni ulatuses ja lisaks kulub 3,2 miljonit krooni " +
							     "rahvuskoondiste välisvõistluste lähetusele. Kergejõustikuliidu " +
							     "poolt korraldatavaid võistlusi, sealhulgas juunis Kadrioru " +
							     "staadionil toimuvaid Euroopa II liiga karikavõistlusi rahastame " +
							     "7,6 miljoni krooniga, selgitas Raiend. " +
							     "EKJL-i presidendi Erich Teigamägi sõnul on eelolev võistlushooaeg " +
							     "tulemas pingeline ning pakub mitmeid põnevaid väljakutseid nii " +
							     "sportlastele kui alaliidule. Suvehooajale teevad ilusa sissejuhatuse " +
							     "märtsis Valencias toimuvad sisemaailmameistrivõistlused. " +
							     "Täna hommikul kinnitas EKJL-i juhatus sise-MMi koondisesse " +
							     "kolmikhüppaja Kaire Leibaku, kes on tänaseks ainsa sportlasena " +
							     "täitnud MM-normi. Wild cardiga lähetatakse Valencia jõuproovile " +
							     "tõkkejooksja Rene Oruman, selgitas Teigamägi. " +
							     "Kergejõustikuliidu peatreeneri Aivo Normaku kinnitusel treenivad " +
							     "sportlased juba täna kindla sihiga jõuda olümpiamängudeks tippvormi " +
							     "ning kergejõustikuliit tagab selle, et kõik sportlased saaksid " +
							     "spordiaasta tähtsündmuseks igati kvaliteetse ja kaasaegse " +
							     "ettevalmistuse. Tänavu on varasemast rohkem sportlasi oma " +
							     "treeningplaani kavandanud ühe või mitu pikemaajalist lõunalaagrit. " +
							     "Hooaja avastardil olümpiamängude A-normi täitnud (64,64m — 18.02.08, " +
							     "Vaasa) maailmameister Gerd Kanter lendab juba homme selle hooaja teise " +
							     "lõunalaagrisse Tenerifele, Hispaaniasse, kinnitas Normak. Teine " +
							     "kettaheitehiid Aleksander Tammert on Aafrikas treeninud alates " +
							     "detsembri keskpaigast ning naaseb Eestisse alles aprillis. Andrus " +
							     "Värnik aga on talvehooajal treeninud kodus, kuid kevadeks on ta " +
							     "plaanitud paar ettevalmistuslaagrit ka soojemas kliimas. " +
							     "Normaku sõnul treenib Ksenija Balta olümpiamänge silmas pidades " +
							     "nii mitmevõistluse alasid kui kaugushüpet. Ka Kaire Leibak on teinud " +
							     "talvel mitu korralikku võistlust ning loodame näha sama häid ning miks " +
							     "mitte veel paremaid tulemusi ka Valencias ning suvistel võistlustel, " +
							     "lisas Normak. Talvehooajal viievõistluses Eesti rekordi püstitanud " +
							     "Kaie Kand alustab ettevalmistust Eestis ja aprilli-maisse on planeeritud " +
							     "kaks lõunalaagrit Hispaanias. Kõik meeste mitmevõistluse koondislased, " +
							     "eesotsas Andres Rajaga, on samuti kindlad, et kevadine ettevalmistus " +
							     "saab läbi viidud soojemas kliimas."); */

		String heaven = new String("There's a lady who's sure all that glitters is gold " +
				"And she's buying a stairway to heaven " +
				"And when she gets there she knows if the stores are closed " +
				"With a word she can get what she came for " +
				"Woe oh oh oh oh oh " +
				"And she's buying a stairway to heaven " +
				"There's a sign on the wall but she wants to be sure " +
				"And you know sometimes words have two meanings " +
				"In a tree by the brook there's a songbird who sings " +
				"Sometimes all of our thoughts are misgiven " +
				"Woe oh oh oh oh oh " +
				"And she's buying a stairway to heaven " +
				"There's a feeling I get when I look to the west " +
				"And my spirit is crying for leaving " +
				"In my thoughts I have seen rings of smoke through the trees " +
				"And the voices of those who stand looking " +
				"Woe oh oh oh oh oh " +
				"And she's buying a stairway to heaven " +
				"And it's whispered that soon, if we all call the tune " +
				"Then the piper will lead us to reason " +
				"And a new day will dawn for those who stand long " +
				"And the forest will echo with laughter " +
				"And it makes me wonder " +
				"If there's a bustle in your hedgerow " +
				"Don't be alarmed now " +
				"It's just a spring clean for the May Queen " +
				"Yes there are two paths you can go by " +
				"but in the long run " +
				"There's still time to change the road you're on " +
				"Your head is humming and it won't go in case you don't know " +
				"The piper's calling you to join him " +
				"Dear lady can't you hear the wind blow and did you know " +
				"Your stairway lies on the whispering wind " +
				"And as we wind on down the road " +
				"Our shadows taller than our soul " +
				"There walks a lady we all know " +
				"Who shines white light and wants to show " +
				"How everything still turns to gold " +
				"And if you listen very hard " +
				"The tune will come to you at last " +
				"When all are one and one is all " +
				"To be a rock and not to roll " +
				"Woe oh oh oh oh oh " +
				"And she's buying a stairway to heaven " +
				"There's a lady who's sure all that glitters is gold " +
				"And she's buying a stairway to heaven " +
				"And when she gets there she knows if the stores are closed " +
				"With a word she can get what she came for " +
				"And she's buying a stairway to heaven, uh uh uh. ");
		
        String[] splititud = heaven.split("\\s");
	
		// Remove punctuation
		for (int i = 0; i < splititud.length; i++) {
			if (splititud[i].endsWith(",") ||
					splititud[i].endsWith(".") ||
					splititud[i].endsWith("!") ||
					splititud[i].endsWith("?") ||
					splititud[i].endsWith(":"))
			{
				splititud[i] = splititud[i].substring(0, splititud[i].length()-1);
			}
		}
		// Output the original text
		System.out.println(heaven);

		// Remove all duplicate words...
		String[] removedDuplicates = DuplicateRemoverImpl.removeDuplicateStrings(splititud);
		// ... and output them
		for (String s : removedDuplicates) {
			System.out.println(s);
		}

		System.out.println("-------------------------------------------");
		
		// Calculate frequency of all unique words...
		TreeMap<String, Integer> freqTable = WordFrequencyCalculator.calculateFrequenciesOf(splititud);
		// ... and output them all
		for(Map.Entry<String, Integer> e : freqTable.entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}

		// Output conclusion
		System.out.println("Words in original text: " + splititud.length);
		System.out.println("Unique words: " + removedDuplicates.length);
	}
}
