/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package dogacel.kotlinx.protobuf.gen

import kotlin.test.Test

class AppTest {
    @Test
    fun shouldWork() {
        CodeGenerator.generateFile(
            "test_file", test.Test.getDescriptor()
        )
    }

    @Test
    fun conformance() {
        CodeGenerator.generateFile(
            "conformance", com.google.protobuf_test_messages.proto3.TestMessagesProto3.getDescriptor()
        )
    }

    @Test
    fun classSpecs() {
        val specs = CodeGenerator.buildClassSpecs(
//            test.Test.getDescriptor()
            com.google.protobuf_test_messages.proto3.TestMessagesProto3.getDescriptor()
        )

        specs.forEach { (descriptor, className) ->
            println(descriptor.fullName)
            println(className)
        }
    }
}
