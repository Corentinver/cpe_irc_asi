export enum Family {
    Default
}

export enum Affinity {
    Default
}

export interface Card {
    id: number;
    name: string;
    description: string;
    family: Family;
    affinity: Affinity;
    energy: number;
    hp: number;
    path: string;
    price: number;
}