package dogacel.kotlinx.protobuf.gen

import com.google.protobuf.Descriptors

/**
 * A set of options to customize the generated code.
 *
 * @property packagePrefix Prefix to add to the generated package name.
 * @property useCamelCase Whether to use camel case for field names. Default is `true`.
 * @property autoGenerateDependencies Only used if generator is initialized using a set of
 * [Descriptors.FileDescriptor]. Generates the classes for inferred dependencies if set to `true`.
 * Default is `true`. Note if you set this to `false` you need to add the dependencies manually otherwise
 * generated code might not compie.
 *
 * @constructor Create empty Code generator options
 */
data class CodeGeneratorOptions(
    val packagePrefix: String = "",
    val useCamelCase: Boolean = true,
    val autoGenerateDependencies: Boolean = true,
    val generateServices: Boolean = true,
    val generateGrpcServices: Boolean = true,
    val generateGrpcMethodsSuspend: Boolean = true,
    val wellKnownTypes: WellKnownTypes = DefaultWellKnownTypes,
) {
    companion object {
        fun parse(parameter: String): CodeGeneratorOptions {
            val tokens = parameter.split(',')
            val (rawValues, rawFlags) = tokens.partition { it.contains("=") }

            val values = rawValues.associate { rawValue -> rawValue.split('=').let { it[0] to it[1] } }
            val flags = rawFlags.toSet()

            return CodeGeneratorOptions(
                packagePrefix = values["package_prefix"] ?: "",
                useCamelCase = flags.contains("use_snake_case").not(),
                generateServices = flags.contains("disable_services").not(),
                generateGrpcMethodsSuspend = flags.contains("disable_grpc_methods_suspend").not(),
            )
        }
    }
}
