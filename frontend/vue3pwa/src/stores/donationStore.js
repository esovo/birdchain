import { defineStore } from 'pinia';

export const donationStore = defineStore({
    id: 'dStore',
    state: () => ({
        donation_id: '',
    }),
    actions: {
        setDoation_id(value) {
            this.donation_id = value;
        },
    },
});