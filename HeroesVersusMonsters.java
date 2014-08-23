import java.util.*;

public class HeroesVersusMonsters
{
    // members
    public static final int MAX_MONSTERS = 3;
    public static final int MAX_HEROES = 3;

    private Hero[] _heroes;
    private Monster[] _monsters;
    private Scanner _scan;
    private Random _gen;

    // name: constructor
    // desc: initializes _scan and _gen, as well as creating an array of
    // heroes and an array of monsters
    // params: none
    // return: n/a

    public HeroesVersusMonsters()
    {
	int i;

	_scan = new Scanner(System.in);
	_gen = new Random();
	_heroes = new Hero[MAX_HEROES];
	_monsters = new Monster[MAX_MONSTERS];

	i = 0;
	_heroes[i++] = new Warrior(_scan, _gen);
	_heroes[i++] = new Sorceress(_scan, _gen);
	_heroes[i++] = new Thief(_scan, _gen);

	i = 0;
	_monsters[i++] = new Ogre(_scan, _gen);
	_monsters[i++] = new Gremlin(_scan, _gen);
	_monsters[i++] = new Skeleton(_scan, _gen);
    }

    // name: play_game
    // desc: lets the player choose a character, generate the random opponent,
    // resets health values (in case it was played previously), receives the
    // user's name, and runs a loop of rounds until someone is victorious
    // params: none
    // return: void
    // 1) Let the user choose a character
    // 2) Generate a random monster
    // 3) Reset health values
    // 4) User inputs name
    // 5) while no one has 0 or less hit points, continue the game (steps 6 and 7)
    // 6) Hero takes a turn
    // 7) Monster takes a turn
    // 8) If hero loses all his health first, print a message
    // 9) If monster loses all his health first, print a message

    public void play_game()
    {
	int character, enemy;
	int i = 1;
	character = choose_character();
	enemy = Math.abs(_gen.nextInt() % MAX_MONSTERS);

	_heroes[character].reset_for_game();
	_monsters[enemy].reset_for_game();


	System.out.print("Enter your name: ");
	_heroes[character]._name = _scan.nextLine();

	System.out.println();
	System.out.println("It's " + _heroes[character]._name + " the " + _heroes[character]._class_type +
			   " versus " + _monsters[enemy]._name +  " the " + _monsters[enemy]._class_type + "!");
	System.out.println("FIGHT!");

	while(_heroes[character]._hit_points > 0 && _monsters[enemy]._hit_points > 0)
	    {
		System.out.println();
		System.out.println("Round " + i + ":");
		_heroes[character].take_turn(_monsters[enemy]);
		_monsters[enemy].attack(_heroes[character]);
		i++;
	    }
	if(_heroes[character]._hit_points < 0)
	    System.out.println("OVERKILL!");
	if(_heroes[character]._hit_points <= 0)
	    System.out.println("You have died!");
	if(_monsters[enemy]._hit_points < 0)
	    System.out.println("OVERKILL!");
	if(_monsters[enemy]._hit_points <= 0)
	    System.out.println("You are victorious!");
    }

    // name: choose_character
    // desc: Lets the player choose from the available heroes
    // params: none
    // return: int
    // 1) 0: Warrior
    // 2) 1: Sorceress
    // 3) 2: Thief
    // 4) choice = _scan.nextInt();
    // 5) return choice;

    private int choose_character()
    {
	int choice;
	System.out.println("Choose an option (enter a number)");
	System.out.println("0: Warrior");
	System.out.println("1: Sorceress");
	System.out.println("2: Thief");

	choice = _scan.nextInt();
	while (choice < 0 || choice > 2)
	    choice = _scan.nextInt();

	_scan.nextLine();
	return choice;
    }

    // name: play_again
    // desc: asks the user to play again
    // params: none
    // return: boolean
    // 1) resp = _scan.next();
    // 2) if (resp.equalsIgnoreCase("yes")
    // 	return true;
    // 3) return false;

    public boolean play_again()
    {
	String resp;
	System.out.print("Play again? (Yes/No): ");
	resp = _scan.next();

	if (resp.equalsIgnoreCase("yes"))
	    return true;

	return false;
    }

}
