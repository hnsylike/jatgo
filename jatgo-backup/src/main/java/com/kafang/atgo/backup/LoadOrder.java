package com.kafang.atgo.backup;

import org.springframework.core.Ordered;

public interface LoadOrder {

	int FIRST = Ordered.HIGHEST_PRECEDENCE;

	int SECOND = FIRST + 1;

	int LAST = Ordered.LOWEST_PRECEDENCE;

}
