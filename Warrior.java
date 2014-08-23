import java.util.*;

public class Warrior extends Hero
{

    // name: constructor
    // desc: initializes base stats and passes scan and gen to the parent
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) super(scan, gen);
    // 2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.

    public Warrior(Scanner scan, Random gen)
    {
	super(scan, gen);

	_hit_points = 125;
	_speed = 4;
	_hit_chance = 0.8;
	_min_dmg = 35;
	_max_dmg = 60;
	_block_chance = 0.2;
	_class_type = "Warrior";
    }
   
    // name: special_ability (OVERRIDE)
    // desc: Warrior's Crushing Blow allows more damage to be dealt
    // params: Monster enemy
    // return: void
    // 1) chance = _gen.nextDouble();
    // 2) if (chance <= .4)

    public void special_ability(Monster enemy)
    {
	double chance;
	int damage;
	chance = _gen.nextDouble();

	if (chance <= .4)
	    {
		damage = Math.abs(_gen.nextInt(175 - 75) + 75);
		System.out.println("Crushing Blow successfully hits for " + damage + " points of damage!");
		enemy.take_damage(damage);
	    }
	else
	    System.out.println("Crushing Blow missed!");
    }

    // name: reset_for_game (OVERRIDE)
    // desc: Resets the health for the character to begin a new game
    // params: none
    // return: void
    // 1) _hit_points = 125;

   public void reset_for_game()
    {
	_hit_points = 125;
    }

}
