### Exercises i Matadorprojektet og lidt nedarving

Opgave 1 og 2 er knyttet til Matadorprojektet. I skal gå ind på https://github.com/tessG/E22Matador og hente nyeste version af Matador. Opgave 3 er muligvis nemmest. Start eventuelt med den.

Opgaver 1 og 2 er måske lidt sværere end ellers, da I skal rette i et kompliceret program. Prøv jer frem og se hvor langt I kan komme. Hvis I går i stå, så skriv evt noget pseudokode eller UML over hvad I tænker, der skal ske. Det er godt at tænke igennem også selvom I ikke helt kan få det ned i fungerende kode. 

Den sidste opgave handler om nedarving og er ikke relateret til Matador. 

## Task 1: Beregn værdier i Tax klassen
Når der skal beregnes skat, har vi brug for at kende en spillers samlede værdier, dvs summen af rede penge og værdien af ejede grunde, rederier og bryggerier (samt eventuelt huse og hoteller, men dem ser vi bort fra for nu). Det skal I lave en metode til nu. Ligenu returnerer onReject metoden blot 10% af de penge spilleren har på sin konto. I denne opgave skal vi sørge for at der returnerens 10% af pengene plus den samlede værdi af spillerens skøder. 


1.a I klassen Tax skal du lave metoden calculateAssets(Player p). Metoden skal beregne og returnere spillerens samlede værdier.

1.b I metoden calculateAssets() skal du først finde ud af hvor mange rede penge spilleren har. Gem fx dette i en variable kaldet assets. 

1.c Dernæst skal du finde værdien af spillerens grunde. Det kan vi ikke endnu, fordi vi ikke ved hvilke grunde hver enkelt spiller ejer. Derfor skal du lave et felt ArrayList<Property> deeds i klassen Player og du skal lave en metode addDeed(Property p) også i klassen Player. I addDeed-metoden skal du tilføje den Property, der kommer ind som parameter, til listen af deeds.

1.d Vi skal dernæst sikre, at når en spiller køber en Property, bliver denne lagt i spillerens liste af Properties. Derfor skal I ind i koden der hvor spilleren vælger at købe en grund, betaler for den og bliver sat som ejer af grunden (det lavede vi i onsdags). Her skal du tilføje en linje, der kalder spillerens addDeed() med den købte Property. 




 <details>
        <summary>
            Hint
 </summary>
Du skal kigge i Property-klassens onLand()-metode for at finde der hvor spillere kan købe grunden.


</details>

 <details>
        <summary>
            Hint
 </summary>
  Du tilføjer den pågældende Property ved at give "this" med til addDeed(), altså addDeed(this). Det ser mærkeligt ud, men det betyder "det objekt, som har den metode jeg står i, skal gives med som parameter."


</details>


1.e Nu kan du lave en metode i Player, som kan give dig værdien af alle spillerens grunde. Den kan fx hedde getPropertyValues(). Metoden løber alle spillerens deeds igennem og lægger cost sammen og returnerer summen. 

1.f Du kan nu kalde metoden fra Tax klassens calculateAssets() og lægge beløbet til din lokale variable assets fra 1.b. Til sidst skal du returnere assets. Metoden kan du bruge i Tax-klassens onReject() til at beregne hvor meget spilleren skal betale i skat. Implementer dette og test at det virker. 

1.g Test i spillet at din kode virker ved at ændre resultvariablen i thowAndMove() i Game-klassen så du tvinger spilleren til at lande på Tax-feltet. 

## Task 2: Træk et chancekort
Når en spiller lander på et "Chance"-felt skal der trækkes et chancekort. Du skal nu lave et antal chancekort og sørge for, at de kan blive trukket, når man lander på et Chance-felt.

2.a Lav en tekstfil (.csv eller .txt) med værdier for chancekortene. Formatet skal være en tekst (det som står på kortet), en udgift (hvis spillere skal betale noget) og en indtægt (hvis spillere får penge). Hvis der ikke er udgifter eller indtægter forbundet med kortet, lader du de to tal være 0. Data skal være kommasepareret. 

Du må selv bestemme hvad der skal stå på chancekortene. Hvis du ikke kender til chancekort i Matador, så se eksempler her: https://spilguru.dk/matador-regler/. Du behøver ikke at lave mere end 10 kort, men læg evt dine forslag til kort på Discord, så andre kan kopiere. På den måde kan I alle hurtigt få lavet et stort datasæt. 

2.b Lav en klasse ChanceCard som repræsenterer chancekortene. Giv klassen fornuftige felter, konstruktør og getter-metoder (ingen setter, da kortene aldrig vil ændre sig). 

2.c Lav en metode readChanceData() i klassen FileIO, som læser din fil. Lad dig evt. inspirere af readBoardData(), da den skal ligne den.

2.d Du skal ændre lidt i metoden gameSetup i klassen Game. Her skal du kalde metoden readChanceData() og gemme resultatet i et array, som du sender til Boards konstruktør sammen med fieldData (udvid konstruktøren i Board, så den nu tager et array af fielddata og et array af chancedata).

2.e Lav et felt i klassen Board, som er et array af ChanceCards. Feltet skal være statisk. Lav en metode i Board kaldet createChanceCards, som opretter ChanceCard-objekter og gemmer dem i dette array. Metoden skal være privat og kaldes fra Boards konstruktør. Du kan lade dig inspirere af hvordan createFields() metoden virker.

2.f Lav en variable index i klassen Board, som også skal være statisk. Denne variable skal bruges til at holde styr på hvilket kort i bunken (arrayet) vi er nået til, det vil sige hvilket kort, der skal trækkes næst. Overvej hvilken type denne variable skal have. 

2.g Lav en statisk metode i klassen Board kaldet getChanceCard(). Metoden skal returnere et ChanceCard. Første gang metoden kaldes, skal kortet på index 0 i ChanceCard-arrayet returneres. Anden gang skal kortet på index 1 returneres og så videre. Når vi har været hele arrayet igennem, skal index starte forfra. 

2.h Når man lander på et Chance-felt, bliver der printet "Træk et kort fra bunken" og brugeren kan svare J eller N til dette. Svarer brugeren J, ryger vi ned i onAccept()-metoden i Chance klassen. Du skal nu ændre i onAccept()-metoden, så du herfra kalder Board.getChanceCard() og printer den besked, der står på det kort, metoden returnerer.  

2.i EKSTRA: Hvis du har tid og lyst kan du udvide metoden onAccept() i Chance, så den spiller, der lander på chancefeltet får fjernet eller tilføjet penge alt efter hvad værdierne for udgift(cost) og indtægt(income) er på kortet (brug pay og recieve metoderne i Player). 

## Task 3: Nedarving
Her skal vi arbejde med tre klasser hvor de to arver fra den tredje. Vi skal se hvad der sker, når to subklasser (children) implementerer en metode forskelligt og vi skal se hvordan subklasser kan behandles som deres superklasser. 

3.1 Lav en klasse Person, med feltet name. Lav også en konstruktør og relevant getter- og setter-metode. Lav derudover metoden boolean addCourse(String course). Metoden skal ikke gøre noget, så du kan lade den returnere true og ikke gøre andet (en dummy-metode). 

EKSTRA: Den korrekte Java-måde at lave en metode, der ikke gør noget, er dog at gøre den abstract, så det kan du gøre i stedet hvis du vil. Hvis du vælger at lade metoden være abstract, skal du også lade klassen være abstract. En abstract metode har ingen {} men skrives sådan: public abstract boolean addCourse(String course);

3.2: Lav to klasser Student og Teacher, som arver fra Person. Lav konstruktører til klasserne, som kalder Persons konstruktør ved at bruge keywordet super(). 

 <details>
        <summary>
            Hint
 </summary>
         For at se hvordan man kalder en superklasses konstruktør, kan du kigge i Matadors klasse Plot. 
    </details>  

3.3 Lav to ArrayList<String> i Student kaldet passedCourses og currentCourses. Lav to ArrayList<String> i Teacher kaldet canTeach og currentCourses. Lav om i konstruktørerne, så der skal gives en ArrayList af passedCourses eller canTeach med, når objektet oprettes. 

3.4 Override metoden addCourse i Student. Når metoden bliver kaldt, skal du sikre, at kurset ikke ligger i den studerendes passedCourses-ArrayList, da en studerende ikke kan tage kurser, som allerede er bestået én gang. Hvis den studerende ikke tidligere har bestået kurset, lægges det i currentCourses. Lad metoden returnere true eller false alt efter om kurset blev tilføjet til currentCourses.

 <details>
        <summary>Hint </summary>
         Se om ikke ArrayList har en metode, der kan hjælpe dig med opgaven.
           </details> 

3.5 Override metoden addCourse i Teacher. Når metoden bliver kaldt, skal du sikre, at kurset ligger i underviserens canTeach-ArrayList, da underviseren skal være kvalificeret til at undervise for at blive sat på kurset. Hvis underviseren er kvalificeret, lægges kurset i currentCourses. Lad metoden returnere true eller false alt efter om kurset blev tilføjet til currentCourses.

3.6 Lav en klasse Main med en main-metode, hvor du tester Student og Teacher. Du skal oprette et antal studerende og et antal undervisere og give dem ArrayLists af beståede kurser eller canTeach-kurser. Gem alle dine objekter i en ArrayList<Person> persons.

3.7 Kør din persons-liste igennem med en for-løkke og tilføj kurset "Java 1.0" til dem alle (sørg for at nogle af dine studerende allerede har bestået dette og andre ikke har, samt at nogle af underviserne er kvalificerede til at undervise i det og andre ikke er). Hver gang ét af dine kald til addCourse() returnerer false, skal du printe navnet på den studerende eller underviseren. Hvis det er en Student skal du også printe " har allerede bestået dette kursus." og hvis det er en Teacher skal du også printe " kan ikke undervise i dette fag".
 <details>
        <summary>Hint </summary>
        For at finde ud af om der er tale om et Student-objekt eller et Teacher-objekt, skal du bruge instanceof. 
         </details> 