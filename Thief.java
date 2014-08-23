import java.util.*;

public class Thief extends Hero
{

    // name: constructor
    // desc: initializes base stats and passes scan and gen to the parent
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) super(scan, gen);
    // 2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.

    public Thief(Scanner scan, Random gen)
    {
	super(scan, gen);

	_hit_points = 75;
	_speed = 6;
	_hit_chance = 0.8;
	_min_dmg = 20;
	_max_dmg = 44;
	_block_chance = 0.4;
	_class_type = "Thief";
    }
   
    // name: special_ability (OVERRIDE)
    // desc: Thief's Surprise Attack allows more damage to be dealt/extra turns
    // params: Monster enemy
    // return: void
    // 1) chance = _gen.nextDouble();
    // 2) if (chance <= .4)
    // 3) if (chance > .8)
    // 4) if (chance < .8 && chance > .4)

    public void special_ability(Monster enemy)
    {
	double chance;
	int damage;
	chance = _gen.nextDouble();

	if(enemy._hit_points <= 0)
	    return;

	if (chance <= .4)
	    {
		damage = Math.abs(_gen.nextInt(_max_dmg - _min_dmg) + _min_dmg);
		System.out.println("Surprise Attack successfully hits for " + damage +
				   " points of damage! Take another turn.");
		enemy.take_damage(damage);
		take_turn(enemy);
	    }
	if (chance > .8)
		System.out.println("You were caught! Nothing happens.");
	if (chance < .8 && chance > .4)
	    {
		if (enemy._hit_points <= 0)
		    return;
		else
		    attack(enemy);
	    }
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
