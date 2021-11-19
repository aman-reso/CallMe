package `in`.app.callme.localDb.models

data class UserCallTypeModel(
    var incomingCallCount: Int = 0,
    var outGoingCallCount: Int = 0,
    var blockedCallCount: Int = 0,
    var missedCallCount: Int = 0
)