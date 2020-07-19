package metaprogramming

import com.spock.model.Product
import spock.lang.Specification

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

class ProductTest extends Specification{

    Class product = Product.class

    def 'product must be noted with an @Entity that has a name and without @Table' () {
        expect:
        product.getAnnotation(Entity).name()
        !product.getAnnotation(Table)
    }

    def '"id" must be noted with @Id, strategy=IDENTITY for generated value and @Column name="id" '() {

        setup:
        def idField = product.getDeclaredField('id')
        def idAnnotation = idField.getDeclaredAnnotation(Id)
        def generatedValueAnnotation = idField.getDeclaredAnnotation(GeneratedValue)
        def columnAnnotation = idField.getDeclaredAnnotation(Column)

        expect:
        idAnnotation
        generatedValueAnnotation.strategy() == GenerationType.IDENTITY
        columnAnnotation.name() == 'id'

    }


}
