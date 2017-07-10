package com.studevs.dummy.restful.in.peace.utility.interfaces;

import java.io.Serializable;

/**
 *
 * @author ashik
 * @param <T>
 */
public interface Replicable<T> extends Serializable {

    public abstract void replicate(final T type);
}
