package fr.score;

public interface SortingPolicy
{
    double value(ScoreItem item);

    static SortingPolicy byScore() {
        return wrap("score", (ScoreItem item) -> (100D * item.correct() / item.attempts()) * Math.sqrt(item.correct()));
    }

    static SortingPolicy byCorrectTime() {
        return wrap("correctTime", (ScoreItem item) -> (double) item.correctTime());
    }

    static SortingPolicy byAttemptTime() {
        return wrap("attemptTime", (ScoreItem item) -> (double) item.attemptTime());
    }

    static SortingPolicy byAttemptTimeAdjust() {
        return wrap("attemptTimeAdjust", (ScoreItem item) -> (double) item.attemptTime() * (100D * item.correct() / item.attempts()) * Math.sqrt(item.correct()));
    }
    
    /* package */ static SortingPolicy wrap(final String message, final SortingPolicy policy) {
        return new SortingPolicy() {

            @Override
            public double value(ScoreItem item) {
                return policy.value(item);
            }
            
            @Override
            public String toString() {
                return message;
            }
        };
    }
}