//Imports
import scala.collection.mutable.{Map,ListBuffer}
import scala.util.Random

//Helper Functions
def randomNumber(min: Int, max: Int) : Int = {
    val r = new Random
    return r.nextInt(max - min + 1) + min
}

//Class Definitions
class MyMentalHealth {

  //Attributes
  private var currentMood : Int = 0
  private var happinessLevel : Int = 0
  private var activities : ListBuffer[String] = ListBuffer.empty[String]
  private var moods : Map[Int, String] = Map.empty[Int, String]

  //Constructor
  def this(moods : Map[Int, String]) {
    this()
    this.moods = moods
    this.happinessLevel = randomNumber(2, 10)
  }

  //Getters
  def getCurrentMood : Int = this.currentMood
  def getHappinessLevel : Int = this.happinessLevel
  def getActivities : ListBuffer[String] = this.activities

  //Setters
  def setCurrentMood(mood : Int) : Unit = {
    if (moods.contains(mood)) {
      this.currentMood = mood
      this.happinessLevel += randomNumber(2, 10)
    } else {
      throw new IllegalArgumentException("This mood does not exist in the MyMentalHealth object")
    }
  }

  def setHappinessLevel(level : Int) : Unit = {
    if (level >= 0 && level <= 10) {
      this.happinessLevel = level
    } else {
      throw new IllegalArgumentException("Happiness level must be between 0 and 10 (inclusive)")
    }
  }

  //Methods
  def addActivity(activity : String) : Unit = {
    this.activities += activity
  }

  def removeActivity(activity : String) : Unit = {
    if (this.activities.contains(activity)) {
      this.activities -= activity
    } else {
      throw new IllegalArgumentException("This activity is not in the list of activities")
    }
  }

  def getMoodByNumber(mood : Int) : String = {
    if (moods.contains(mood)) {
      return moods(mood)
    } else {
      throw new IllegalArgumentException("This mood does not exist in the MyMentalHealth object")
    }
  }

  def getNumberByMood(mood : String) : Int = {
    if (moods.values.toList.contains(mood)) {
      return moods.find(_._2 == mood).get._1
    } else {
      throw new IllegalArgumentException("This mood does not exist in the MyMentalHealth object")
    }
  }

}

//Object Definition
object MyMentalHealth {

  //Attributes
  private val moods : Map[Int, String] = Map(1 -> "Happy", 2 -> "Content", 3 -> "Sad", 4 -> "Depressed")
  private val activities : ListBuffer[String] = ListBuffer("Talking to a friend", "Exercising", "Watching a movie", "Writing in a journal")

  //Getters
  def getMoods : Map[Int, String] = this.moods
  def getActivities : ListBuffer[String] = this.activities

  //Methods
  def newInstance : MyMentalHealth = {
    return new MyMentalHealth(moods)
  }

}