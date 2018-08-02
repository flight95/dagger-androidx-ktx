package androidx.dagger.ktx

import androidx.fragment.app.Fragment
import dagger.MapKey
import dagger.internal.Beta
import kotlin.reflect.KClass

@Suppress("unused")
@Beta
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class FragmentKey(val value: KClass<out Fragment>)