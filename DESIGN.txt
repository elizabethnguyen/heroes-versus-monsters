Description/Requirements: I am creating a game, based off of the everpopular
'Dungeons and Dragons', named 'Heroes Versus Monsters'. This game will give the
player an option of selecting from (currently) three different heroes, and they
will fight a monster opponent chosen at random. Each hero has predetermined
stats, a basic attack, and a special ability. The monster, not user-controlled,
will always attack and attempt to heal if damage is about to be taken. The player
will get to make a choice of what to do during their turn each round. First one
to reach 0 hit points or below (an overkill) loses!

The design of the program is modeled closely off of Eastern's provided structure.

// DungeonCharacter Object
	// members
	protected String _name;
	protected String _class_type;
	protected int _hit_points;
	protected int _speed;
	protected int _min_dmg;
	protected int _max_dmg;
	protected double _hit_chance;
	protected Scanner _scan;
	protected Random _gen;
	
	// methods
	name: constructor
	desc: sets _scan and _gen
	params: Scanner scan, Random gen
	return: n/a
	1) _scan = scan;
	2) _gen = gen;
	
	name: attack
	desc: generates a random number to determine if the character attacks.
	If it checks, then a random number is generated between max and min to
	deal damage to the enemy.
	params: Monster enemy
	return: void
	1) chance = _gen.nextDouble();
	2) if ( chance <= _hit_chance)
	3) damage = Math.abs(_gen.nextInt(_max_dmg - _min_dmg) + _min_dmg);
	
	name: take_damage
	desc: The character takes damage if attack passes.
	params: int damage
	return: void
	1) _hit_points -= damage;
	2) System.out.println(toString());
	
	name: toString
	desc: Prints the character and the health remaining.
	params: none
	return: String
	1) String info = _name + " has " + _hit_points + " health reamining.";
	2) return info;
	
// Hero Object (ABSTRACT CLASS) extends DungeonCharacter
	// members
	protected double _block_chance;
	
	// methods
	name: constructor
	desc: passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	
	name: special_ability (ABSTRACT)
	desc: an abstract method for heroes to have special abilities
	params: Monster enemy
	return: void
	
	name: reset_for_game (ABSTRACT)
	desc: an abstract method to allow characters to reset their health for
	a new game
	params: none
	return: void
	
	name: take_damage (OVERRIDE)
	desc: The hero has a chance to block if he is about to take damage.
	params: int damage
	return: void
	1) chance = _gen.nextDouble();
	2) if (chance <= _block_chance)
	
	name: take_turn
	desc: Allows the player to choose their action for a new round
	params: Monster enemy
	return: void
	1) System.out.println("Choose your action (enter a number");
	2) System.out.println("1: A basic attack");
	3) System.out.println("2: A special ability");
	4) User response determines next action
	
// Warrior Object extends Hero
	// methods
	name: constructor
	desc: initializes base stats and passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.
	
	name: special_ability (OVERRIDE)
	desc: Warrior's Crushing Blow allows more damage to be dealt
	params: Monster enemy
	return: void
	1) chance = _gen.nextDouble();
	2) if (chance <= .4)
	
	name: reset_for_game (OVERRIDE)
	desc: Resets the health for the character to begin a new game
	params: none
	return: void
	1) _hit_points = 125;
	
// Sorceress Object extends Hero
	// methods
	name: constructor
	desc: initializes base stats and passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.
	
	name: special_ability (OVERRIDE)
	desc: Sorceress' Heal allows health to be gained
	params: Monster enemy
	return: void
	1) chance = _gen.nextDouble();
	2) if (chance <= .4)
	
	name: reset_for_game (OVERRIDE)
	desc: Resets the health for the character to begin a new game
	params: none
	return: void
	1) _hit_points = 75;
	
// Thief Object extends Hero
	// methods
	name: constructor
	desc: initializes base stats and passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.
	
	name: special_ability (OVERRIDE)
	desc: Thief's Surprise Attack allows more damage to be dealt/extra turns
	params: Monster enemy
	return: void
	1) chance = _gen.nextDouble();
	2) if (chance <= .4)
	3) if (chance > .8)
	4) if (chance < .8 && chance > .4)
	
	name: reset_for_game (OVERRIDE)
	desc: Resets the health for the character to begin a new game
	params: none
	return: void
	1) _hit_points = 75;
	
	
// Monster Object (ABSTRACT CLASS) extends DungeonCharacter
	// members
	protected double _heal_chance;
	protected int _max_heal;
	protected int _min_heal;
	
	// methods
	name: constructor
	desc: passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	
	name: attack (OVERRIDE)
	desc: the monster attacks the hero based on _hit_chance
	params: Hero enemy
	return: void
	1) chance = _gen.nextDouble();
	2) if (chance <= _hit_chance)
	
	name: reset_for_game (ABSTRACT)
	desc: an abstract method to allow characters to reset their health for
	a new game
	params: none
	return: void
	
	name: take_damage (OVERRIDE)
	desc: The monster has a chance to heal if he is about to take damage.
	params: int damage
	return: void
	1) chance = _gen.nextDouble();
	2) if (chance <= _heal_chance)
	
	name: attempt_heal
	desc: Allows the monster to try and heal based on _heal_chance
	params: none
	return: void
	1) change = _gen.nextDouble();
	2) if (chance <= _heal_chance)
	
// Ogre Object extends Monster
	// methods
	name: constructor
	desc: initializes base stats and passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.
	
	name: reset_for_game (OVERRIDE)
	desc: Resets the health for the character to begin a new game
	params: none
	return: void
	1) _hit_points = 200;
	
// Gremlin Object extends Monster
	// methods
	name: constructor
	desc: initializes base stats and passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.
	
	name: reset_for_game (OVERRIDE)
	desc: Resets the health for the character to begin a new game
	params: none
	return: void
	1) _hit_points = 70;
	
// Skeleton Object extends Monster
	// methods
	name: constructor
	desc: initializes base stats and passes scan and gen to the parent
	params: Scanner scan, Random gen
	return: n/a
	1) super(scan, gen);
	2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.
	
	name: reset_for_game (OVERRIDE)
	desc: Resets the health for the character to begin a new game
	params: none
	return: void
	1) _hit_points = 100;
	
// HeroesVersusMonsters Object
	// members
	public static final int MAX_MONSTERS = 3;
	public static final int MAX_HEROES = 3;
	
	private Hero[] _heroes;
	private Monster[] _monsters;
	private Scanner _scan;
	private Random _gen;
	
	// methods
	name: constructor
	desc: initializes _scan and _gen, as well as creating an array of
	heroes and an array of monsters
	params: none
	return: n/a
	
	name: play_game
	desc: lets the player choose a character, generate the random opponent,
	resets health values (in case it was played previously), receives the
	user's name, and runs a loop of rounds until someone is victorious
	params: none
	return: void
	1) Let the user choose a character
	2) Generate a random monster
	3) Reset health values
	4) User inputs name
	5) while no one has 0 or less hit points, continue the game (steps 6 and 7)
	6) Hero takes a turn
	7) Monster takes a turn
	8) If hero loses all his health first, print a message
	9) If monster loses all his health first, print a message
	
	name: choose_character
	desc: Lets the player choose from the available heroes
	params: none
	return: int
	1) 0: Warrior
	2) 1: Sorceress
	3) 2: Thief
	4) choice = _scan.nextInt();
	5) return choice;
	
	name: play_again
	desc: asks the user to play again
	params: none
	return: boolean
	1) resp = _scan.next();
	2) if (resp.equalsIgnoreCase("yes")
		return true;
	3) return false;
	
// Main
	1) Initalize a new HeroesVersusMonsters game object
	2) Play the game
	3) While user wants to go again, repeat steps 2 and 3
