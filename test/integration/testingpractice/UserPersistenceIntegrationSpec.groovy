package testingpractice

import grails.test.spock.IntegrationSpec

class UserPersistenceIntegrationSpec extends IntegrationSpec {

    UserController userController

    void "count grades for an specific user"() {

        setup:
        def user = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
        user.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 4.3) )
        user.subjects.add( new Subject(code : "2025966", name:"ALGORITMOS", grade: 3.8) )
        user.subjects.add( new Subject(code : "2026809", name:"CÁTEDRA DE FACULTAD JULIO GARAVITO ARMERO", grade: 3.5) )
        user.subjects.add( new Subject(code : "2025966", name:"LENGUAJES DE PROGRAMACIÓN", grade: 4) )
        user.subjects.add( new Subject(code : "2016707", name:"SISTEMAS OPERATIVOS", grade: 3.1) )
        user.subjects.add( new Subject(code : "2025964", name:"MATEMÁTICAS DISCRETAS II", grade: 4.5) )
        user.subjects.add( new Subject(code : "2025967", name:"REDES DE COMPUTADORES", grade: 4.6) )
        user.subjects.add( new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 2.7) )
        user.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 2.9) )

        when:
        userController = new UserController()
        def count = userController.getGradesCount(user)

        then:
        count == 10

    }

    void "get grades average for an specific user"() {
        setup:
        def user = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
                user.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 4.3) )
                user.subjects.add( new Subject(code : "2025966", name:"ALGORITMOS", grade: 3.8) )
                user.subjects.add( new Subject(code : "2026809", name:"CÁTEDRA DE FACULTAD JULIO GARAVITO ARMERO", grade: 3.5) )
                user.subjects.add( new Subject(code : "2025966", name:"LENGUAJES DE PROGRAMACIÓN", grade: 4) )
                user.subjects.add( new Subject(code : "2016707", name:"SISTEMAS OPERATIVOS", grade: 3.1) )
                user.subjects.add( new Subject(code : "2025964", name:"MATEMÁTICAS DISCRETAS II", grade: 4.5) )
                user.subjects.add( new Subject(code : "2025967", name:"REDES DE COMPUTADORES", grade: 4.6) )
                user.subjects.add( new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 2.7) )
                user.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 2.9) )

        when:
        userController = new UserController()
        def average = userController.getGradesAverages(user)

        then:
        average == 3.4
    }

    void "get grades average for a group of user"() {
        setup:
        def user1 = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
        user1.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 4.3) )
        user1.subjects.add( new Subject(code : "2025966", name:"ALGORITMOS", grade: 3.8) )
        user1.subjects.add( new Subject(code : "2026809", name:"CÁTEDRA DE FACULTAD JULIO GARAVITO ARMERO", grade: 3.5) )
        user1.subjects.add( new Subject(code : "2025966", name:"LENGUAJES DE PROGRAMACIÓN", grade: 4) )
        user1.subjects.add( new Subject(code : "2016707", name:"SISTEMAS OPERATIVOS", grade: 3.1) )
        user1.subjects.add( new Subject(code : "2025964", name:"MATEMÁTICAS DISCRETAS II", grade: 4.5) )
        user1.subjects.add( new Subject(code : "2025967", name:"REDES DE COMPUTADORES", grade: 4.6) )
        user1.subjects.add( new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 2.7) )
        user1.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 2.9) )

        def user2 = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
        user2.subjects.add( new Subject(code : "2025966", name:"ALGORITMOS", grade: 3.8) )
        user2.subjects.add( new Subject(code : "2026809", name:"CÁTEDRA DE FACULTAD JULIO GARAVITO ARMERO", grade: 3.5) )
        user2.subjects.add( new Subject(code : "2025966", name:"LENGUAJES DE PROGRAMACIÓN", grade: 4) )
        user2.subjects.add( new Subject(code : "2016707", name:"SISTEMAS OPERATIVOS", grade: 3.1) )
        user2.subjects.add( new Subject(code : "2025964", name:"MATEMÁTICAS DISCRETAS II", grade: 4.5) )
        user2.subjects.add( new Subject(code : "2025967", name:"REDES DE COMPUTADORES", grade: 4.6) )

        def user3 = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
        user3.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 4.3) )
        user3.subjects.add( new Subject(code : "2025966", name:"ALGORITMOS", grade: 3.8) )
        user3.subjects.add( new Subject(code : "2026809", name:"CÁTEDRA DE FACULTAD JULIO GARAVITO ARMERO", grade: 3.5) )
        user3.subjects.add( new Subject(code : "2025966", name:"LENGUAJES DE PROGRAMACIÓN", grade: 4) )
        user3.subjects.add( new Subject(code : "2016707", name:"SISTEMAS OPERATIVOS", grade: 3.1) )
        user3.subjects.add( new Subject(code : "2025964", name:"MATEMÁTICAS DISCRETAS II", grade: 4.5) )
        user3.subjects.add( new Subject(code : "2025967", name:"REDES DE COMPUTADORES", grade: 4.6) )

        def user4 = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
        user4.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 4.3) )
        user4.subjects.add( new Subject(code : "2025966", name:"ALGORITMOS", grade: 3.8) )
        user4.subjects.add( new Subject(code : "2026809", name:"CÁTEDRA DE FACULTAD JULIO GARAVITO ARMERO", grade: 3.5) )
        user4.subjects.add( new Subject(code : "2025966", name:"LENGUAJES DE PROGRAMACIÓN", grade: 4) )
        user4.subjects.add( new Subject(code : "2025964", name:"MATEMÁTICAS DISCRETAS II", grade: 4.5) )
        user4.subjects.add( new Subject(code : "2025967", name:"REDES DE COMPUTADORES", grade: 4.6) )

        def user5 = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
        user5.subjects.add( new Subject(code : "2015168", name:"FUNDAMENTOS DE MATEMÁTICAS", grade: 4.3) )
        user5.subjects.add( new Subject(code : "2025966", name:"ALGORITMOS", grade: 3.8) )
        user5.subjects.add( new Subject(code : "2026809", name:"CÁTEDRA DE FACULTAD JULIO GARAVITO ARMERO", grade: 3.5) )
        user5.subjects.add( new Subject(code : "2025966", name:"LENGUAJES DE PROGRAMACIÓN", grade: 4) )
        user5.subjects.add( new Subject(code : "2016707", name:"SISTEMAS OPERATIVOS", grade: 3.1) )

        when:
        userController = new UserController()

        def prom = userController.getGradesAveragesGroup( [user1,user2,user3,user4,user5 ])

        then:
        print( prom )

    }

    void "get PA"() {
        setup:
        def user = new User(code: "1022399818", name: "Carlos Cogua", mail: "cacoguaa@unal.edu.co",
                subjects: new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 5))
        user.subjects.add( new Subject(code : "1000006", name:"CÁLCULO EN VARIAS VARIABLES", grade: 2) )

        when:
        userController = new UserController()
        def average = userController.getPA(user)

        then:
        println( user.subjects.grade)
        println(average)
    }


}
