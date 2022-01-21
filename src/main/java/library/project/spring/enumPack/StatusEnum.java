package library.project.spring.enumPack;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum StatusEnum {
    STUDENT(1), EMPLOYEE(2), PUPIL(2), OTHER(3);
    private Integer value;

    private static final Map<Integer, StatusEnum> VALUES = new ConcurrentHashMap<Integer, StatusEnum>();

    static {
        for (StatusEnum type : StatusEnum.values()) {
            VALUES.put(type.value, type);
        }
    }

    private StatusEnum(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static StatusEnum getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value.intValue());
    }
}
