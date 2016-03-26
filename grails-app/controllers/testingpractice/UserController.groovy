package testingpractice

class UserController {

    def index() { }

    def getGradesCount(User user){
        return user.getSubjects().size()
    }

    def getGradesAverages(User user){
        def sumGrades = 0
        def size = user.subjects.size()
        user.subjects.each {
            if (it.grade != null) sumGrades += it.grade
            else size-=1
        }
        return sumGrades / size
    }

    def getGradesAveragesGroup(ArrayList users){
        def list = []
        users.each {
            list.add( getGradesAverages(it) )
        }
        return list

    }
    def getPA(User user){
        float total  = 0.0
        def i = 0
        user.subjects.each{
            total += it.grade
            i +=1
        }
        return total/i
    }
}
