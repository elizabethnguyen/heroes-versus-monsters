import java.util.*;

public class Sorceress extends Hero
{

    // name: constructor
    // desc: initializes base stats and passes scan and gen to the parent
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) super(scan, gen);
    // 2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.

    public Sorceress(Scanner scan, Random gen)
    {
	super(scan, gen);

	_hit_points = 75;
	_speed = 5;
	_hit_chance = 0.7;
	_min_dmg = 25;
	_max_dmg = 45;
	_block_chance = 0.3;
	_class_type = "Sorceress";
    }
   
    // name: special_ability (OVERRIDE)
    // desc: Sorceress' Heal allows health to be gained
    // params: Monster enemy
    // return: void
    // 1) chance = _gen.nextDouble();
    // 2) if (chance <= .4)

    public void special_ability(Monster enemy)
    {
	double chance;
	int heal;
	chance = _gen.nextDouble();

	if (chance <= .4)
	    {
		heal = Math.abs(_gen.nextInt(40 - 20) + 40);
		System.out.println("Heal is successfully cast for " + heal + " points of health!");
		_hit_points += heal;
	    }
	else
	    System.out.println("Heal failed!");
    }

    // name: reset_for_game (OVERRIDE)
    // desc: Resets the health for the character to begin a new game
    // params: none
    // return: void
    // 1) _hit_points = 75;

   public void reset_for_game()
    {
	_hit_points = 75;
    }

}
