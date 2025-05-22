package AdvancedKotlin.AnnotationsReflection

// Custom annotation for task metadata
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class TaskInfo(
    val description: String,
    val priority: Int = 0
) {
    /*
     * Annotations Context:
     * - @TaskInfo annotates classes or properties with metadata (description, priority).
     * - @Target: Specifies valid targets (classes, properties).
     * - @Retention(RUNTIME): Ensures annotation is available at runtime for reflection.
     * - Java Equivalent: Java annotation with @Target(ElementType.TYPE, ElementType.FIELD) and @Retention(RetentionPolicy.RUNTIME).
     * - From Your Knowledge: Aligns with metadata concepts in design patterns.
     * - Android Relevance: Similar to Room’s @Entity or Retrofit’s @Query annotations.
     */
}

