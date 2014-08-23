import java.util.*;

public class Gremlin extends Monster
{

    // name: constructor
    // desc: initializes base stats and passes scan and gen to the parent
    // params: Scanner scan, Random gen
    // return: n/a
    // 1) super(scan, gen);
    // 2) Allocate _hit_points, _speed, _hit_chance, _min_dmg, _max_dmg, etc.

    public Gremlin(Scanner scan, Random gen)
    {
	super(scan, gen);
	_hit_points = 70;
	_speed = 5;
	_hit_chance = .8;
	_min_dmg = 15;
	_max_dmg = 30;
	_heal_chance = .4;
	_min_heal = 20;
	_max_heal = 40;
	_class_type = "Gremlin";
	_name = "Gremlin";
    }

    // name: reset_for_game (OVERRIDE)
    // desc: Resets the health for the character to begin a new game
    // params: none
    // return: void
    // 1) _hit_points = 70;

   public void reset_for_game()
    {
	_hit_points = 70;
    }

}
