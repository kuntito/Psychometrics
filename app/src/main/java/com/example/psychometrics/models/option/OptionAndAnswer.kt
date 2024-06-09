package com.example.psychometrics.models.option


class OptionsAndAnswer<T>(
    val options: List<Option<T>>,
    val answerId: Int,
) {
    init {
        val minOptionCount = 2
        require(options.size >= minOptionCount) {
            "options must have at least $minOptionCount elements, it has ${options.size}"
        }
        require(options.map { it.id }.distinct().size == options.size){
            "all option ids should be unique"
        }
        require(options.any { it.id == answerId }) {
            "answer id ($answerId) does not exist in (${options})"
        }
    }

    val answer: Option<T>
        get() = options.find {option ->
            option.id == answerId
        }!!
}