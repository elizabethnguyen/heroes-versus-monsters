import java.util.*;

public abstract class Hero extends DungeonCharacter
{
    // members
    protected double _block_chance;

    // name: constructor
    // desc: passes scan and gen to the parent
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) super(scan, gen);

    public Hero(Scanner scan, Random gen)
    {
	super(scan, gen);
    }

    // name: special_ability (ABSTRACT)
    // desc: an abstract method for heroes to have special abilities
    // params: Monster enemy
    // return: void

    public abstract void special_ability(Monster enemy);

    // name: reset_for_game (ABSTRACT)
    // desc: an abstract method to allow characters to reset their health for
    // a new game
    // params: none
    // return: void

    public abstract void reset_for_game();

    // name: take_damage (OVERRIDE)
    // desc: The hero has a chance to block if he is about to take damage.
    // params: int damage
    // return: void
    // 1) chance = _gen.nextDouble();
    // 2) if (chance <= _block_chance)

    public void take_damage(int damage)
    {
	double chance;
	chance = _gen.nextDouble();

	if (chance <= _block_chance)
	    {
		System.out.println("The attack was blocked!");
		System.out.println(toString());
	    }
	else
	    super.take_damage(damage);
    }

    // name: take_turn
    // desc: Allows the player to choose their action for a new round
    // params: Monster enemy
    // return: void
    // 1) System.out.println("Choose your action (enter a number");
    // 2) System.out.println("1: A basic attack");
    // 3) System.out.println("2: A special ability");
    // 4) User response determines next action

    public void take_turn(Monster enemy)
    {
	int resp = 5;
	if ( enemy._hit_points <= 0)
	    return;

	System.out.println(toString());
	System.out.println("Choose your action (enter a number)");
	System.out.println("1: A basic attack");
	System.out.println("2: A special ability");

	while (resp < 1 || resp > 2)
	    {
		resp = _scan.nextInt();
		System.out.println();
		if (resp == 1)
		    attack(enemy);
		if (resp == 2)
		    special_ability(enemy);
	    }

    }

}
