package testingpractice

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(GradesController)
class GradesControllerSpec extends Specification {

/*  academicRecord = academicRecord.replaceAll("á","a");
    academicRecord = academicRecord.replaceAll("Á","A");
    academicRecord = academicRecord.replaceAll("e","e");
    academicRecord = academicRecord.replaceAll("É","E");
    academicRecord = academicRecord.replaceAll("í","i");
    academicRecord = academicRecord.replaceAll("Í","I");
    academicRecord = academicRecord.replaceAll("ó","o");
    academicRecord = academicRecord.replaceAll("Ó","o");
    academicRecord = academicRecord.replaceAll("ú","u");
    academicRecord = academicRecord.replaceAll("Ú","U");
    academicRecord = academicRecord.replaceAll("ü","u");
    academicRecord = academicRecord.replaceAll("Ü","U");
    academicRecord = academicRecord.replaceAll("ñ","n");
    academicRecord = academicRecord.replaceAll("Ñ","N");

    println(academicRecord)*/

    def academicRecord = ""

    def setup() {
    }

    def cleanup() {
    }

    def "testing periods size"() {
        when:
        def periods = controller.getPeriods(academicRecord)
        def periodsSize = periods.size()
        then:"size of periods"
        periodsSize == 1
    }

    def "testing periods name"() {
        when:
        def periodNames = controller.getPeriodNames(academicRecord)
        then:"last item of periods"
        periodNames[7].toString().trim().equals("2015-II")
    }

    def "getPeriods accepts null values"() {
        when:
        controller.getPeriods("")

        then:
        thrown Exception
    }
    def "get subjects size"(){
        given: "A periods array"
        def periods = controller.getPeriods(academicRecord)

        when: "The users attempts to get the subjects"
        def subjects = controller.getSubjects(periods)

        then: "The subjects size is..."
        subjects.size() == 4
    }
    def "get subjects PAPA"(){
        given: "A periods array"
        def periods = controller.getPeriods(academicRecord)
        def PAPA = controller.getPAPA(periods)

        expect:
        PAPA[a] == c

        where: "The PAPA in each period is..."
        a << [0, 1, 2, 3]
        c << [4.592857142857143, 4.404166666666666, 4.405882352941176, 4.35576923076923]
    }

    def "get subjects PA"(){
        given: "A periods array"
        def periods = controller.getPeriods(academicRecord)
        def PAPA = controller.getPA(periods)

        expect:
        PAPA[a] == c

        where: "The PA in each period is..."
        a || c
        0 || 4.592857142857143
        1 || 4.404166666666666
        2 || 4.405882352941176
        3 || 4.35576923076923
    }

    def "get progress"(){
        given: "An academic record"
       def components = controller.getAdvanceComponents(academicRecord)

        expect:
        components[a] == c

        where: "The progress in each component is..."
        a || c
        0 || 51
        1 || 51
        2 || 81
        3 || 45
        4 || 33
        5 || 17
        6 || 12
        7 || 12
    }

}
